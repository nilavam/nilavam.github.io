import csv
import os

#set the body of your email here
mail_content = '''Hello {name},

username: {uname}
roll Number: {rno}

Your MA101 endterm exam has been graded.


Scores and graders for each problem are as follows:

1 (Soumyadeep): {s1}	
2 (Nilava): {s1}	


Comments for each problem are as follows:		

1: {c1}
2: {c1}


Total Score (out of 20):   {total}



--
Nilava Metya
BSc 2nd year
Chennai Mathematical Institute
'''

sub = 'MA1101' #enter subject of your message here

sub = '\''+sub+'\''
with open("contact.csv") as file:
	reader = csv.reader(file)
	next(reader)  # Skip header row
	for [name, rno, uname, s1, c1, s2, c2, total] in reader: #enter column names in order as the appear in the file
		to = '\''+uname+'\''
		mail = mail_content.format(name=name, rno=rno, uname=uname, s1=s1, c1=c1, s2=s2, c2=c2, total=total)
		mail = mail.replace('\n','\\n')
		mail = mail.replace('\t','\\t')
		mail = '\"'+mail+'\"'
		command = 'echo '+mail+' | mail -s ' + sub + ' ' + to
		os.system(command)
		print('Mail Sent to ' + uname)
