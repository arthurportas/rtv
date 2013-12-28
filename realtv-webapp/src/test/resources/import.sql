-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212')


insert into Level (id, dificultyLevel, timeAvailableToAnswer) values (1, 1, 30)
insert into Level (id, dificultyLevel, timeAvailableToAnswer) values (2, 2, 20)
insert into Level (id, dificultyLevel, timeAvailableToAnswer) values (3, 3, 15)
insert into Level (id, dificultyLevel, timeAvailableToAnswer) values (4, 4, 10)
insert into Level (id, dificultyLevel, timeAvailableToAnswer) values (5, 5, 5)


--Theme is the owner, so create first them associate questions
insert into Theme (id, theme, description) values (1,'Genérico','Jogo Comum!')
insert into Theme (id, theme, description) values (2,'Celebridades','Jogo Especial com celebridades!')
insert into Theme (id, theme, description) values (3,'Actores','Jogo Especial com actores de televisão e teatro!')
insert into Theme (id, theme, description) values (4,'Desporto','Jogo Especial com atletas!')

--Question is the owner, so create first them associate answers
insert into Question (id, question, themeId) values (1, 'Quem foi o 1 Rei de Portugal?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (1, 'Herman Jose', 'D. Afonso Henriques', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (2, 'Cristiano Ronaldo', 'D. Afonso Henriques', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (3, 'D. Dinis', 'D. Afonso Henriques', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (4, 'D. Afonso Henriques', 'D. Afonso Henriques', 1)

insert into Question (id, question, themeId) values (2, 'Qual é a capital de Portugal?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (5, 'Lisboa', 'Lisboa', 2)
insert into Answer (id, answer, correctAnswer, questionId) values (6, 'Porto', 'Lisboa', 2)
insert into Answer (id, answer, correctAnswer, questionId) values (7, 'Mirandela', 'Lisboa', 2)
insert into Answer (id, answer, correctAnswer, questionId) values (8, 'Aveiro', 'Lisboa', 2)

insert into Question (id, question, themeId) values (3, 'Onde joga actualmente Ibraimhovic?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (9, 'A.C.Milan', 'Paris-Saint-German', 3)
insert into Answer (id, answer, correctAnswer, questionId) values (10, 'Paris-Saint-German', 'Paris-Saint-German', 3)
insert into Answer (id, answer, correctAnswer, questionId) values (11, 'F.C.Barcelona', 'Paris-Saint-German', 3)
insert into Answer (id, answer, correctAnswer, questionId) values (12, 'F.C.Aljustrel', 'Paris-Saint-German', 3)

insert into Question (id, question, themeId) values (4, 'Em que país se irá realizar o mundial de futebol de 2014?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (13, 'Brasil', 'Brasil', 4)
insert into Answer (id, answer, correctAnswer, questionId) values (14, 'Botswana', 'Brasil', 4)
insert into Answer (id, answer, correctAnswer, questionId) values (15, 'Espanha', 'Brasil', 4)
insert into Answer (id, answer, correctAnswer, questionId) values (16, 'Vietname', 'Brasil', 4)

insert into Question (id, question, themeId) values (5, 'Em quais cidades marca presença a Universidade do Minho?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (17, 'Porto. V.P.Âncora', 'Braga. Guimarães', 5)
insert into Answer (id, answer, correctAnswer, questionId) values (18, 'Braga. Guimarães', 'Braga. Guimarães', 5)
insert into Answer (id, answer, correctAnswer, questionId) values (19, 'V.Real. Braga', 'Braga. Guimarães', 5)
insert into Answer (id, answer, correctAnswer, questionId) values (20, 'Barcelos. V.Castelo', 'Braga. Guimarães', 5)

insert into Question (id, question, themeId) values (6, 'Qual o nome da série televisiva onde participou Pamela Anderson?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (21, 'Baywatch', 'Baywatch', 6)
insert into Answer (id, answer, correctAnswer, questionId) values (22, 'Beverly Hills.90210', 'Baywatch', 6)
insert into Answer (id, answer, correctAnswer, questionId) values (23, 'Batman and Robin', 'Baywatch', 6)
insert into Answer (id, answer, correctAnswer, questionId) values (24, 'Dr. House', 'Baywatch', 6)

insert into Question (id, question, themeId) values (7, 'O que significa a palavra "felpudo"?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (25, 'Doce', 'Peludo', 7)
insert into Answer (id, answer, correctAnswer, questionId) values (26, 'Querido', 'Peludo', 7)
insert into Answer (id, answer, correctAnswer, questionId) values (27, 'Amoroso', 'Peludo', 7)
insert into Answer (id, answer, correctAnswer, questionId) values (28, 'Peludo', 'Peludo', 7)

insert into Question (id, question, themeId) values (8, 'Por que nome é conhecido o vocalista dos Da Weasel?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (29, 'Tetris', 'Pacman', 8)
insert into Answer (id, answer, correctAnswer, questionId) values (30, 'Super Mário', 'Pacman', 8)
insert into Answer (id, answer, correctAnswer, questionId) values (31, 'Pacman', 'Pacman', 8)
insert into Answer (id, answer, correctAnswer, questionId) values (32, 'Paco', 'Pacman', 8)

insert into Question (id, question, themeId) values (9, 'Quantos dias tem um ano bissexto?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (33, '365', '366', 9)
insert into Answer (id, answer, correctAnswer, questionId) values (34, '356', '366', 9)
insert into Answer (id, answer, correctAnswer, questionId) values (35, '366', '366', 9)
insert into Answer (id, answer, correctAnswer, questionId) values (36, '355', '366', 9)

insert into Question (id, question, themeId) values (10, 'Qual é a primeira pessoa do presente indicativo do verbo "ler"?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (37, 'Eu li', 'Eu leio', 10)
insert into Answer (id, answer, correctAnswer, questionId) values (38, 'Eu lerei', 'Eu leio', 10)
insert into Answer (id, answer, correctAnswer, questionId) values (39, 'Eu lia', 'Eu leio', 10)
insert into Answer (id, answer, correctAnswer, questionId) values (40, 'Eu leio', 'Eu leio', 10)

insert into Question (id, question, themeId) values (11, 'Como são conhecidos os lisboetas?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (41, 'Estranhos', 'Alfacinhas', 11)
insert into Answer (id, answer, correctAnswer, questionId) values (42, 'Alfacetas', 'Alfacinhas', 11)
insert into Answer (id, answer, correctAnswer, questionId) values (43, 'Alface', 'Alfacinhas', 11)
insert into Answer (id, answer, correctAnswer, questionId) values (44, 'Alfacinhas', 'Alfacinhas', 11)

insert into Question (id, question, themeId) values (12, 'Como se chama à frase que formula uma pergunta?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (45, 'Imperativa', 'Interrogativa', 12)
insert into Answer (id, answer, correctAnswer, questionId) values (46, 'Interrogativa', 'Interrogativa', 12)
insert into Answer (id, answer, correctAnswer, questionId) values (47, 'Exclamativa', 'Interrogativa', 12)
insert into Answer (id, answer, correctAnswer, questionId) values (48, 'Declarativa', 'Interrogativa', 12)

insert into Question (id, question, themeId) values (13, 'Que tipo de alimento é um tremoço?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (49, 'Cereal', 'Leguminosa', 13)
insert into Answer (id, answer, correctAnswer, questionId) values (50, 'Fruto seco', 'Leguminosa', 13)
insert into Answer (id, answer, correctAnswer, questionId) values (51, 'Leguminosa', 'Leguminosa', 13)
insert into Answer (id, answer, correctAnswer, questionId) values (52, 'Enchido', 'Leguminosa', 13)

insert into Question (id, question, themeId) values (14, 'Qual o nome do companheiro da boneca Barbie?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (53, 'Romeu', 'Ken', 14)
insert into Answer (id, answer, correctAnswer, questionId) values (54, 'David', 'Ken', 14)
insert into Answer (id, answer, correctAnswer, questionId) values (55, 'John', 'Ken', 14)
insert into Answer (id, answer, correctAnswer, questionId) values (56, 'Ken', 'Ken', 14)

insert into Question (id, question, themeId) values (15, 'Qual destes órgãos pertence ao sistema respiratório?', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (57, 'Laringe', 'Laringe', 15)
insert into Answer (id, answer, correctAnswer, questionId) values (58, 'Bexiga', 'Laringe', 15)
insert into Answer (id, answer, correctAnswer, questionId) values (59, 'Coração', 'Laringe', 15)
insert into Answer (id, answer, correctAnswer, questionId) values (60, 'Fígado', 'Laringe', 15)

--ShowType
insert into ShowType (id, type, description) values (1, 0,'Modo demo.')
insert into ShowType (id, type, description) values (2, 1,'Modo tempo real.')

--Demo Shows
insert into Show (id, name, beginning, ending, showTypeId) values (1, 'Quem Quer Ser Milionário.','2012-12-26 05:22:30','2012-12-26 06:22:30' ,1)
insert into Show (id, name, beginning, ending, showTypeId) values (2, 'Quem Quer Ser Milionário.','2012-12-27 05:22:30','2012-12-27 06:22:30', 1)
insert into Show (id, name, beginning, ending, showTypeId) values (3, 'Quem Quer Ser Milionário.','2012-12-28 05:22:30','2012-12-28 06:22:30', 1)
insert into Show (id, name, beginning, ending, showTypeId) values (4, 'Quem Quer Ser Milionário.','2012-12-29 05:22:30','2012-12-29 06:22:30', 1)
insert into Show (id, name, beginning, ending, showTypeId) values (5, 'Quem Quer Ser Milionário.','2012-12-30 05:22:30','2012-12-30 06:22:30', 1)
insert into Show (id, name, beginning, ending, showTypeId) values (6, 'Quem Quer Ser Milionário.','2012-12-31 05:22:30','2012-12-31 06:22:30', 1)
insert into Show (id, name, beginning, ending, showTypeId) values (7, 'Quem Quer Ser Milionário.','2013-01-01 05:22:30','2013-01-01 06:22:30', 1)
insert into Show (id, name, beginning, ending, showTypeId) values (8, 'Quem Quer Ser Milionário.','2013-01-02 05:22:30','2013-01-02 06:22:30', 1)
insert into Show (id, name, beginning, ending, showTypeId) values (9, 'Quem Quer Ser Milionário.','2013-01-03 05:22:30','2013-01-03 06:22:30', 1)
insert into Show (id, name, beginning, ending, showTypeId) values (10, 'Quem Quer Ser Milionário.','2013-01-04 05:22:30','2013-01-04 06:22:30', 1)
insert into Show (id, name, beginning, ending, showTypeId) values (11, 'Quem Quer Ser Milionário.','2013-01-05 05:22:30','2013-01-05 06:22:30', 1)

