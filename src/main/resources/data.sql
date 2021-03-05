
insert into role (id, name) values (1, 'ROLE_ADMIN');
insert into role (id, name) values (2, 'ROLE_USER');

--insert into user_role (user_id, role_id) values (3,1);
--insert into user_role (user_id, role_id) values (3,2);


insert into artist (id,location,name) values (1,'Korea','BLACKPINK');
insert into artist (id,location,name) values (2,'Korea','BTS');
insert into artist (id,location,name) values (3,'USA','Backstreet Boys');
insert into artist (id,location,name) values (4,'USA','Taylor Swift');
insert into artist (id,location,name) values (5,'USA','Artist_5');
insert into artist (id,location,name) values (6,'Japan','Artist_6');
insert into artist (id,location,name) values (7,'Mexico','Artist_7');
insert into artist (id,location,name) values (8,'Puerto Rico','Artist_8');
insert into artist (id,location,name) values (9,'Spain','Artist_9');
insert into artist (id,location,name) values (10,'France','Artist_10');
--
insert into genre(id,description,name) values (1,'Funky fresh music from Korea','K-pop');
insert into genre(id,description,name) values (2,'Funky fresh music from USA','Pop');
insert into genre(id,description,name) values (3,'Funky fresh music from anywhere','Funk');
insert into genre(id,description,name) values (4,'Funky fresh music from Mexico','Rock');
insert into genre(id,description,name) values (5,'Its okay music I suppose','Classic');
--
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (1,'THE ALBUM',13.99,'NEW','2020-10-02','/album_1',15,1,1);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (2,'DDU DU DDU DU',12.99,'NEW','2020-10-15','/album_2',15,1,1);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (3,'ON',11.99,'NEW','2020-12-15','/album_3',15,2,1);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (4,'MAP OF THE SOUL: 7',9.99,'NEW','2020-11-02','/album_4',15,2,1);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (5,'FUTURE',5.99,'NEW','2020-5-02','/album_5',15,3,2);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (6,'LARGER THAN LIFE',15.99,'NEW','2020-8-02','/album_6',15,3,2);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (7,'MELLINIUM',13.99,'NEW','2020-4-02','/album_7',15,4,2);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (8,'SWIFTERS',12.99,'NEW','2020-9-02','/album_8',15,5,3);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (9,'ROCKIN AROUND',11.99,'NEW','2020-10-25','/album_9',15,5,3);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (10,'CHIC A DEE',9.99,'NEW','2020-10-7','/album_10',15,6,1);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (11,'LUCIOUS CUCIOUS',5.99,'NEW','2020-10-02','/album_11',15,7,1);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (12,'SOMETHING',15.99,'NEW','2020-10-02','/album_12',15,8,4);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (13,'WHY OR WHY NOT',13.99,'NEW','2020-10-02','/album_13',15,9,5);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (14,'LOVE ME',12.99,'NEW','2020-10-02','/album_14',15,9,4);
insert into album(id,name,price,status,date,image,inventory,artist_id,genre_id) values (15,'HATE YOU',11.99,'NEW','2020-10-02','/album_15',15,10,2);
--
insert into song(id,inventory,name,price,album_id,artist_id) values (1,12,'WHAT WILL I DO',0.99,1,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (2,13,'B PINK OR BE GREEN',0.99,1,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (3,14,'BLACK PACK',0.99,1,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (4,15,'CRAZY OVER U',0.99,1,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (5,16,'HOW YOU LIKE THAT',0.99,1,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (6,17,'PRETTY SAVAGE',0.99,2,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (7,18,'REALLY',0.99,2,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (8,19,'FOREVER YOUNG',0.99,2,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (9,20,'AS IF YOUR LAST',0.99,2,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (10,21,'LOVESICK',0.99,2,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (11,22,'ON',0.99,3,2);
insert into song(id,inventory,name,price,album_id,artist_id) values (12,23,'IDOL',0.99,3,2);
insert into song(id,inventory,name,price,album_id,artist_id) values (13,24,'NOT TODAY',0.99,3,5);
insert into song(id,inventory,name,price,album_id,artist_id) values (14,25,'BE LONG TO ME',0.99,4,2);
insert into song(id,inventory,name,price,album_id,artist_id) values (15,26,'22',0.99,4,3);
insert into song(id,inventory,name,price,album_id,artist_id) values (16,27,'1982',0.99,4,4);
insert into song(id,inventory,name,price,album_id,artist_id) values (17,28,'SONG 17',0.99,5,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (18,29,'SONG 18',0.99,5,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (19,30,'SONG 19',0.99,5,5);
insert into song(id,inventory,name,price,album_id,artist_id) values (20,31,'SONG 20',0.99,5,4);
insert into song(id,inventory,name,price,album_id,artist_id) values (21,32,'SONG 21',0.99,6,5);
insert into song(id,inventory,name,price,album_id,artist_id) values (22,33,'SONG 22',0.99,6,4);
insert into song(id,inventory,name,price,album_id,artist_id) values (23,34,'SONG 23',0.99,15,5);
insert into song(id,inventory,name,price,album_id,artist_id) values (24,35,'SONG 24',0.99,13,3);
insert into song(id,inventory,name,price,album_id,artist_id) values (25,36,'SONG 25',0.99,7,2);
insert into song(id,inventory,name,price,album_id,artist_id) values (26,37,'SONG 26',0.99,15,3);
insert into song(id,inventory,name,price,album_id,artist_id) values (27,38,'SONG 27',0.99,14,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (28,39,'SONG 28',0.99,7,5);
insert into song(id,inventory,name,price,album_id,artist_id) values (29,40,'SONG 29',0.99,8,2);
insert into song(id,inventory,name,price,album_id,artist_id) values (30,41,'SONG 30',0.99,13,3);
insert into song(id,inventory,name,price,album_id,artist_id) values (31,42,'SONG 31',0.99,8,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (32,43,'SONG 32',0.99,8,1);
insert into song(id,inventory,name,price,album_id,artist_id) values (33,44,'SONG 33',0.99,9,3);
insert into song(id,inventory,name,price,album_id,artist_id) values (34,45,'SONG 34',0.99,9,2);
insert into song(id,inventory,name,price,album_id,artist_id) values (35,46,'SONG 35',0.99,12,3);
insert into song(id,inventory,name,price,album_id,artist_id) values (36,47,'SONG 36',0.99,9,2);
insert into song(id,inventory,name,price,album_id,artist_id) values (37,48,'SONG 37',0.99,10,4);
insert into song(id,inventory,name,price,album_id,artist_id) values (38,49,'SONG 38',0.99,10,5);
insert into song(id,inventory,name,price,album_id,artist_id) values (39,50,'SONG 39',0.99,11,5);
insert into song(id,inventory,name,price,album_id,artist_id) values (40,51,'SONG 40',0.99,10,4);



--insert into artist values(1,'Korea','BLACKPINK');
--insert into artist values(2,'Korea','BTS');
--
--insert into song (name, inventory, price, album_id, artist_id) values ('Good News',4, 10, 1, 1 );
--insert into song (name, inventory, price, album_id, artist_id) values ('News',4, 10, 1, 2 );
--insert into song (name, inventory, price, album_id, artist_id) values ('Alphabet Good News',4, 10, 1, 2 );
--insert into song (name, inventory, price, album_id, artist_id) values ('bananas',4, 10, 1, 1 );
--
--insert into genre (id, name, description) values (1, 'Pop', 'produced the most hits');
--insert into genre (id, name, description) values (2, 'Country', 'Country music often consists of ballads and dance tunes with generally simple forms');
--
--
--insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id) values(1,'THE ALBUM',9.99,'2020-02-10','img/the_album.png',99,'NEW',1,1);
--insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(2,'THE NEXT ALBUM',13.99,'2021-02-01','img/photo.png',15,'NEW',1,1);
--insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(3,'THE FINAL ALBUM',19.99,'2021-05-05','img/final.png',3,'USED',2,2);
--insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id) values(4,'THE ALBUM',9.99,'2020-02-10','img/the_album.png',99,'NEW',1,2);
--insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(5,'THE NEXT ALBUM',13.99,'2021-02-01','img/photo.png',15,'NEW',1,null);
--insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(6,'THE FINAL ALBUM',19.99,'2021-05-05','img/final.png',3,'USED',2,null);
--insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id) values(7,'THE ALBUM',9.99,'2020-02-10','img/the_album.png',99,'NEW',1,2);
--insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(8,'THE NEXT ALBUM',13.99,'2021-02-01','img/photo.png',15,'NEW',1,1);
--insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(9,'THE FINAL ALBUM',19.99,'2021-05-05','img/final.png',3,'USED',2,null);
--
--
--insert into shopping_cart (id, album_id, song_id, user_id ) values (1, 2, null, 1);
--insert into shopping_cart (id, album_id, song_id, user_id ) values (2, null, 3, 1);
--insert into shopping_cart (id, album_id, song_id, user_id ) values (3, 7, null, 2);
--insert into shopping_cart (id, album_id, song_id, user_id ) values (4, 7, null, 1);


