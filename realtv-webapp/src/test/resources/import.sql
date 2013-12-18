-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212')

--Question is the owner, so create first them associate answers
insert into Question (id, question) values (1, 'Quem foi o 1 Rei de Portugal?')
insert into Answer (id, answer, correctAnswer, questionId) values (1, 'Herman Jose', 'D. Afonso Henriques', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (2, 'Cristiano Ronaldo', 'D. Afonso Henriques' , 1)
insert into Answer (id, answer, correctAnswer, questionId) values (3, 'D. Dinis', 'D. Afonso Henriques' ,1)
insert into Answer (id, answer, correctAnswer, questionId) values (4, 'D. Afonso Henriques', 'D. Afonso Henriques',1)