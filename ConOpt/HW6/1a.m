clc;
clear all;

load("regression_data.mat");    %loading data
sdpvar x;   %declaring variable
d = 7;  %degree of our polynomial
[p, cp, mp] = polynomial(x,d);  %getting the polynomial p, coefficients cp, monomials mp

obj = 0;    %initializing objective
for i = 1:20    %for loop to add to consecutive sum of squares error
    obj = obj + (fvec(i) - replace(p,x,xvec(i)) )^2;
end

%setting up the problem and solving the optimization problem
options = sdpsettings('verbose',0,'solver','sdpt3');
optimize([], obj, options);

%displaying optimal value and optimal polynomial
sdisplay(double(obj));
sdisplay(double(cp)' * mp);

%plotting the polynomial along with data
plot(0:0.1:7, polyval(fliplr(double(cp)'), 0:0.1:7));
hold on;
scatter(xvec,fvec,'filled');
xlabel("xvec");
ylabel("fvec");
xlim([0,7]);
ylim([-80,40]);
f = gcf;
exportgraphics(f,'leastsquare.png','Resolution',300);
hold off;