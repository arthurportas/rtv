-- You can use this file to load seed data into the database using SQL statements

insert into QuestionLevel (id, dificultyLevel, timeAvailableToAnswer) values (1, 1, 30)
insert into QuestionLevel (id, dificultyLevel, timeAvailableToAnswer) values (2, 2, 20)
insert into QuestionLevel (id, dificultyLevel, timeAvailableToAnswer) values (3, 3, 15)
insert into QuestionLevel (id, dificultyLevel, timeAvailableToAnswer) values (4, 4, 10)
insert into QuestionLevel (id, dificultyLevel, timeAvailableToAnswer) values (5, 5, 5)

--Theme is the owner, so create first them associate questions
insert into Theme (id, theme, description) values (1,'Genérico','Jogo Comum!')
insert into Theme (id, theme, description) values (2,'Celebridades','Jogo Especial com celebridades!')
insert into Theme (id, theme, description) values (3,'Actores','Jogo Especial com actores de televisão e teatro!')
insert into Theme (id, theme, description) values (4,'Desporto','Jogo Especial com atletas!')

--Question is the owner, so create first them associate answers
insert into Question (id, question, themeId, questionLevelId) values (1, 'Quem foi o 1 Rei de Portugal?', 1, 1)
insert into Answer (id, answer, correctAnswer, questionId) values (1, 'Herman Jose', 'D. Afonso Henriques', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (2, 'Cristiano Ronaldo', 'D. Afonso Henriques', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (3, 'D. Dinis', 'D. Afonso Henriques', 1)
insert into Answer (id, answer, correctAnswer, questionId) values (4, 'D. Afonso Henriques', 'D. Afonso Henriques', 1)

insert into Question (id, question, themeId, questionLevelId) values (2, 'Qual é a capital de Portugal?', 1, 1)
insert into Answer (id, answer, correctAnswer, questionId) values (5, 'Lisboa', 'Lisboa', 2)
insert into Answer (id, answer, correctAnswer, questionId) values (6, 'Porto', 'Lisboa', 2)
insert into Answer (id, answer, correctAnswer, questionId) values (7, 'Mirandela', 'Lisboa', 2)
insert into Answer (id, answer, correctAnswer, questionId) values (8, 'Aveiro', 'Lisboa', 2)

insert into Question (id, question, themeId, questionLevelId) values (3, 'Onde joga actualmente Ibraimhovic?', 1, 1)
insert into Answer (id, answer, correctAnswer, questionId) values (9, 'A.C.Milan', 'Paris-Saint-German', 3)
insert into Answer (id, answer, correctAnswer, questionId) values (10, 'Paris-Saint-German', 'Paris-Saint-German', 3)
insert into Answer (id, answer, correctAnswer, questionId) values (11, 'F.C.Barcelona', 'Paris-Saint-German', 3)
insert into Answer (id, answer, correctAnswer, questionId) values (12, 'F.C.Aljustrel', 'Paris-Saint-German', 3)

insert into Question (id, question, themeId, questionLevelId) values (4, 'Em que país se irá realizar o mundial de futebol de 2014?', 1, 1)
insert into Answer (id, answer, correctAnswer, questionId) values (13, 'Brasil', 'Brasil', 4)
insert into Answer (id, answer, correctAnswer, questionId) values (14, 'Botswana', 'Brasil', 4)
insert into Answer (id, answer, correctAnswer, questionId) values (15, 'Espanha', 'Brasil', 4)
insert into Answer (id, answer, correctAnswer, questionId) values (16, 'Vietname', 'Brasil', 4)

insert into Question (id, question, themeId, questionLevelId) values (5, 'Em quais cidades marca presença a Universidade do Minho?', 1, 1)
insert into Answer (id, answer, correctAnswer, questionId) values (17, 'Porto. V.P.Âncora', 'Braga. Guimarães', 5)
insert into Answer (id, answer, correctAnswer, questionId) values (18, 'Braga. Guimarães', 'Braga. Guimarães', 5)
insert into Answer (id, answer, correctAnswer, questionId) values (19, 'V.Real. Braga', 'Braga. Guimarães', 5)
insert into Answer (id, answer, correctAnswer, questionId) values (20, 'Barcelos. V.Castelo', 'Braga. Guimarães', 5)

insert into Question (id, question, themeId, questionLevelId) values (6, 'Qual o nome da série televisiva onde participou Pamela Anderson?', 1, 2)
insert into Answer (id, answer, correctAnswer, questionId) values (21, 'Baywatch', 'Baywatch', 6)
insert into Answer (id, answer, correctAnswer, questionId) values (22, 'Beverly Hills.90210', 'Baywatch', 6)
insert into Answer (id, answer, correctAnswer, questionId) values (23, 'Batman and Robin', 'Baywatch', 6)
insert into Answer (id, answer, correctAnswer, questionId) values (24, 'Dr. House', 'Baywatch', 6)

insert into Question (id, question, themeId, questionLevelId) values (7, 'O que significa a palavra "felpudo"?', 1, 1)
insert into Answer (id, answer, correctAnswer, questionId) values (25, 'Doce', 'Peludo', 7)
insert into Answer (id, answer, correctAnswer, questionId) values (26, 'Querido', 'Peludo', 7)
insert into Answer (id, answer, correctAnswer, questionId) values (27, 'Amoroso', 'Peludo', 7)
insert into Answer (id, answer, correctAnswer, questionId) values (28, 'Peludo', 'Peludo', 7)

insert into Question (id, question, themeId, questionLevelId) values (8, 'Por que nome é conhecido o vocalista dos Da Weasel?', 1, 2)
insert into Answer (id, answer, correctAnswer, questionId) values (29, 'Tetris', 'Pacman', 8)
insert into Answer (id, answer, correctAnswer, questionId) values (30, 'Super Mário', 'Pacman', 8)
insert into Answer (id, answer, correctAnswer, questionId) values (31, 'Pacman', 'Pacman', 8)
insert into Answer (id, answer, correctAnswer, questionId) values (32, 'Paco', 'Pacman', 8)

insert into Question (id, question, themeId, questionLevelId) values (9, 'Quantos dias tem um ano bissexto?', 1, 2)
insert into Answer (id, answer, correctAnswer, questionId) values (33, '365', '366', 9)
insert into Answer (id, answer, correctAnswer, questionId) values (34, '356', '366', 9)
insert into Answer (id, answer, correctAnswer, questionId) values (35, '366', '366', 9)
insert into Answer (id, answer, correctAnswer, questionId) values (36, '355', '366', 9)

insert into Question (id, question, themeId, questionLevelId) values (10, 'Qual é a primeira pessoa do presente indicativo do verbo "ler"?', 1, 3)
insert into Answer (id, answer, correctAnswer, questionId) values (37, 'Eu li', 'Eu leio', 10)
insert into Answer (id, answer, correctAnswer, questionId) values (38, 'Eu lerei', 'Eu leio', 10)
insert into Answer (id, answer, correctAnswer, questionId) values (39, 'Eu lia', 'Eu leio', 10)
insert into Answer (id, answer, correctAnswer, questionId) values (40, 'Eu leio', 'Eu leio', 10)

insert into Question (id, question, themeId, questionLevelId) values (11, 'Como são conhecidos os lisboetas?', 1, 3)
insert into Answer (id, answer, correctAnswer, questionId) values (41, 'Estranhos', 'Alfacinhas', 11)
insert into Answer (id, answer, correctAnswer, questionId) values (42, 'Alfacetas', 'Alfacinhas', 11)
insert into Answer (id, answer, correctAnswer, questionId) values (43, 'Alface', 'Alfacinhas', 11)
insert into Answer (id, answer, correctAnswer, questionId) values (44, 'Alfacinhas', 'Alfacinhas', 11)

insert into Question (id, question, themeId, questionLevelId) values (12, 'Como se chama à frase que formula uma pergunta?', 1, 4)
insert into Answer (id, answer, correctAnswer, questionId) values (45, 'Imperativa', 'Interrogativa', 12)
insert into Answer (id, answer, correctAnswer, questionId) values (46, 'Interrogativa', 'Interrogativa', 12)
insert into Answer (id, answer, correctAnswer, questionId) values (47, 'Exclamativa', 'Interrogativa', 12)
insert into Answer (id, answer, correctAnswer, questionId) values (48, 'Declarativa', 'Interrogativa', 12)

insert into Question (id, question, themeId, questionLevelId) values (13, 'Que tipo de alimento é um tremoço?', 1, 4)
insert into Answer (id, answer, correctAnswer, questionId) values (49, 'Cereal', 'Leguminosa', 13)
insert into Answer (id, answer, correctAnswer, questionId) values (50, 'Fruto seco', 'Leguminosa', 13)
insert into Answer (id, answer, correctAnswer, questionId) values (51, 'Leguminosa', 'Leguminosa', 13)
insert into Answer (id, answer, correctAnswer, questionId) values (52, 'Enchido', 'Leguminosa', 13)

insert into Question (id, question, themeId, questionLevelId) values (14, 'Qual o nome do companheiro da boneca Barbie?', 1, 5)
insert into Answer (id, answer, correctAnswer, questionId) values (53, 'Romeu', 'Ken', 14)
insert into Answer (id, answer, correctAnswer, questionId) values (54, 'David', 'Ken', 14)
insert into Answer (id, answer, correctAnswer, questionId) values (55, 'John', 'Ken', 14)
insert into Answer (id, answer, correctAnswer, questionId) values (56, 'Ken', 'Ken', 14)

insert into Question (id, question, themeId, questionLevelId) values (15, 'Qual destes órgãos pertence ao sistema respiratório?', 1, 5)
insert into Answer (id, answer, correctAnswer, questionId) values (57, 'Laringe', 'Laringe', 15)
insert into Answer (id, answer, correctAnswer, questionId) values (58, 'Bexiga', 'Laringe', 15)
insert into Answer (id, answer, correctAnswer, questionId) values (59, 'Coração', 'Laringe', 15)
insert into Answer (id, answer, correctAnswer, questionId) values (60, 'Fígado', 'Laringe', 15)

--ShowType
insert into ShowType (id, mode, description) values (1, 0,'Modo demo.')
insert into ShowType (id, mode, description) values (2, 1,'Modo tempo real.')

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

--Client
insert into Client (id, mobileID) values (1, 'y7yfvqxxf@05cybpaylcbc.com')
insert into Client (id, mobileID) values (2, 'rc3oi02honz9@co3n60g0gai.com')
insert into Client (id, mobileID) values (3, '239msh6e@i6jl0omys.com')
insert into Client (id, mobileID) values (4, 'eoe@9n08fgm-ry.com')
insert into Client (id, mobileID) values (5, 'q7lmsbblpx3lt@xcbfcef.com')
insert into Client (id, mobileID) values (6, '437nvq9905vuad@a0u-mq5-60.com')
insert into Client (id, mobileID) values (7, 'r_s.p9@6xoe4nrbc.com')
insert into Client (id, mobileID) values (8, 'tkg.nj2rx17hx7@wtms7yw.com')
insert into Client (id, mobileID) values (9, 'ox-ap-t@7mmen6610uqp.com')
insert into Client (id, mobileID) values (10, 'iat3nd13@rl5dp8rcc1d.com')
insert into Client (id, mobileID) values (11, 'bljk@i0x4-rs.com')
insert into Client (id, mobileID) values (12, '3wzunx-o@nxdwddoy.com')
insert into Client (id, mobileID) values (13, 'wb9@of-i01mua6z.com')
insert into Client (id, mobileID) values (14, 'pubfk55-q@a4z1ir.com')
insert into Client (id, mobileID) values (15, '6ee@642dwl.com')
insert into Client (id, mobileID) values (16, '443@wyxj6jzq3ktd.com')
insert into Client (id, mobileID) values (17, '00ygxrxuxcm3w@1c-bzxi5upte.com')
insert into Client (id, mobileID) values (18, 'r6fuonpnyzhe0g@1uwox2.com')
insert into Client (id, mobileID) values (19, 'tj_wzq@zcfqigc2j15q.com')
insert into Client (id, mobileID) values (20, 'v9z9@wmsqwu4.com')
insert into Client (id, mobileID) values (21, 'cwz1@fqi9t32.com')
insert into Client (id, mobileID) values (22, 'cn-il.bii-bn-@lyqs62s.com')
insert into Client (id, mobileID) values (23, 'tghkaj@qc4rl1zw.com')
insert into Client (id, mobileID) values (24, 'cu7l44ne21@3ffw7y1ciw1.com')
insert into Client (id, mobileID) values (25, 'bgbvak0ilewru@yf9b49i84ea.com')
insert into Client (id, mobileID) values (26, 'lf707o95d@sey1-7z43.com')
insert into Client (id, mobileID) values (27, 'i8i_79b@ep3hs6fl07.com')
insert into Client (id, mobileID) values (28, 'zdlv2dcd-6d2@hrpxowzu-01w.com')
insert into Client (id, mobileID) values (29, '6uo83a4po2q0hb@fnkfwo7xtx.com')
insert into Client (id, mobileID) values (30, 'pp2k_fphu7@hmhbhngo.com')
insert into Client (id, mobileID) values (31, 'thyi8pnaajz3m@7mb-vevi5.com')
insert into Client (id, mobileID) values (32, 'qoza@gd68ergs77.com')
insert into Client (id, mobileID) values (33, 'bzi7pco0jaed@ordp13gbxs.com')
insert into Client (id, mobileID) values (34, 'dhh@la8-cuh70j.com')
insert into Client (id, mobileID) values (35, '8e-ewm25@ltgpgw7u2.com')
insert into Client (id, mobileID) values (36, 'tgo2@07y1pcy.com')
insert into Client (id, mobileID) values (37, '3sayhz2iowc@mb597jbx9puv.com')
insert into Client (id, mobileID) values (38, '3skrpwi_@5odypro.com')
insert into Client (id, mobileID) values (39, 'c-1l1h8wu887@yfem9o.com')
insert into Client (id, mobileID) values (40, '01pploe5o3_brh@paj3cc1.com')
insert into Client (id, mobileID) values (41, '4wjgf7bo334eaei@4s03uo90.com')
insert into Client (id, mobileID) values (42, 'zdb387_s4x7qe4@yn9yrzl4fr.com')
insert into Client (id, mobileID) values (43, 'g.e4zn@rg44i6b.com')
insert into Client (id, mobileID) values (44, '16j697@r2okagq9.com')
insert into Client (id, mobileID) values (45, 'ixwx@8v3ntssvqg6.com')
insert into Client (id, mobileID) values (46, '230w@v1j26vzj.com')
insert into Client (id, mobileID) values (47, 'rmccjz7xhnd4@4jx9wmyt9.com')
insert into Client (id, mobileID) values (48, 'f0v1ei@ui2tu8lakk5.com')
insert into Client (id, mobileID) values (49, 'eu.mf6ro_6.@a6t0edvz6u5.com')
insert into Client (id, mobileID) values (50, 'ib1kinwzkhhsix@9l86fhx5dign.com')
insert into Client (id, mobileID) values (51, 'xuhapsdm@85l3y7wnjo6z.com')
insert into Client (id, mobileID) values (52, 'a98w61o6@spsbte3cgyl.com')
insert into Client (id, mobileID) values (53, '2vex3ub9jkkmc@jo7jd8.com')
insert into Client (id, mobileID) values (54, 'oc5ad7.2agyd@qev964z.com')
insert into Client (id, mobileID) values (55, 'st3ib_@j22b8hpqf.com')
insert into Client (id, mobileID) values (56, 'htf2nlalgu3r@zvns0jkb3ozr.com')
insert into Client (id, mobileID) values (57, 'cu-kvyv5.fq@jmw2uh.com')
insert into Client (id, mobileID) values (58, 'ggn9dvp@ii2tjbz34f.com')
insert into Client (id, mobileID) values (59, 'u_m6jnvy@bb-whg9d.com')

insert into AndroidNotificationServer (id, registeredEmail, GCMAuthorizationKey) values (1, 'arthurportas@gmail.com', 'GCMAuthorizationKey')

--timeSpentPlaying should be a long(millis) updated from Participation
insert into ClientHistory (id, numGamesCompleted, numRightanswers, numWrongAnswers, timeSpentPlaying) values (1, 1, 15, 0, 1263585534000)
insert into ClientHistory (id, numGamesCompleted, numRightanswers, numWrongAnswers, timeSpentPlaying) values (2, 1, 15, 0, 1388605973115)
insert into ClientHistory (id, numGamesCompleted, numRightanswers, numWrongAnswers, timeSpentPlaying) values (3, 1, 15, 0, 1388606038821)
insert into ClientHistory (id, numGamesCompleted, numRightanswers, numWrongAnswers, timeSpentPlaying) values (4, 1, 15, 0, 1388606047776)
insert into ClientHistory (id, numGamesCompleted, numRightanswers, numWrongAnswers, timeSpentPlaying) values (5, 1, 15, 0, 1388606073121)


insert into ShowParticipation (id, lastBeginPlaying, lastEndPlaying, timeSpentPlaying, numGamesCompleted, numRightAnswers, numWrongAnswers) values (1, '2012-12-26 05:22:30','2012-12-26 06:22:30', 1263585534000, 3, 32, 5 )
insert into ShowParticipation (id, lastBeginPlaying, lastEndPlaying, timeSpentPlaying, numGamesCompleted, numRightAnswers, numWrongAnswers) values (2, '2012-12-26 05:22:30','2012-12-26 06:22:30', 1263585535000, 3, 32, 5 )


