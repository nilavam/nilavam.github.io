clc;
clear all;

load("regression_data.mat");    %loading data
sdpvar x_1 x_2 s t;   %declaring variable
inp = [s, t];
x = [x_1, x_2];
d = 4;  %degree of our polynomial
[p, cp, mp] = polynomial(x,d);  %getting the polynomial p, coefficients cp, monomials mp
eta = 0.607567008796;   %optimal value from previous problem

obj = 0;    %initializing the objective
for i = 1:30
    obj = obj + (gvec(i) - replace(p, x, [x1vec(i), x2vec(i)]))^2;
end

%setting up the problem and solving the optimization problem
options = sdpsettings('verbose',0,'solver','sdpt3');
H = hessian(p,x);
constr = [sos(inp * H * inp')]; %sos = non-negative because bivariate quartic
constr = constr + [obj <= eta * 1.75];
optimize(constr, obj, options);

%modifying to display polynomial in 3D
f = sdisplay(replace(p,cp,value(cp)));
f = f{1};
f = replace(f,'^','.^');    
f = replace(f,'*','.*');    
f = str2func(['@(x_1,x_2)' f]);
[X,Y] = meshgrid(0:0.01:1,0:0.01:1);
F = f(X,Y);
mesh(X,Y,F);
hold on
scatter3(x1vec,x2vec,gvec, 'filled', 'red');
xlabel("x1vec");
ylabel("x2vec");
zlabel("gvec");
for i = 1:30
    plot3([x1vec(i) x1vec(i)], [x2vec(i) x2vec(i)], [gvec(i) replace(double(cp)'*mp, x, [x1vec(i), x2vec(i)])]);
end
hold off

sdisplay(value(obj));
sdisplay(double(cp)' * mp);

