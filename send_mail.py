import smtplib, csv, ssl
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders
from email.message import EmailMessage
from getpass import getpass


#set the body of your email here
mail_content = '''Hello {name},

username: {uname}
roll Number: {rno}

Your MA101 endterm exam has been graded.


Scores and graders for each problem are as follows:

1 (Soumyadeep): {s1}	
2 (Nilava): {s2}	


Comments for each problem are as follows:		

1: {c1}
2: {c2}


Total Score (out of 20):   {total}



--
Nilava Metya
BSc 2nd year
Chennai Mathematical Institute
'''


sender_address = input("Your gmail id: ")
sender_pass = getpass("Password: ")


#Create SMTP session for sending the mail
session = smtplib.SMTP('smtp.gmail.com', 587) #use gmail with port
session.starttls() #enable security
session.login(sender_address, sender_pass) #login with mail_id and password

with open("contact.csv") as file:
	reader = csv.reader(file)
	next(reader)  # Skip header row
	for [name, rno, uname, s1, c1, s2, c2, total] in reader: #enter column names in order as the appear in the file
		message = EmailMessage()
		message['From'] = sender_address
		message['To'] = uname
		message['Subject'] = 'MA101 endterm report'
		message.set_content(mail_content.format(name=name, rno=rno, uname=uname, s1=s1, c1=c1, s2=s2, c2=c2, total=total))
		#print a prompt on the terminal that the mail has been sent to the current user:
		print(uname, end=" ")
		session.send_message(message)
		print('Mail Sent')
session.quit()