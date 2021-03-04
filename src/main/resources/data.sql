insert into user (email, password, address, state, zipcode, credit_card, role) values ('user@user.com','password', '1234 apple st', 'NY', '12345', '123456789', 'admin');
insert into user (email, password, address, state, zipcode, credit_card, role) values ('test@test.com','password', '1234 apple st', 'NY', '12345', '123456789', 'admin');


insert into artist values(1,'Korea','BLACKPINK');
insert into artist values(2,'Korea','BTS');
<<<<<<< Updated upstream
insert into song (name, inventory, price, album_id, artist_id) values ('Good News',4, 10, 1, 1 );

insert into album (id, name, price, date, image, inventory, status,artist_id) values(1,'THE ALBUM',9.99,'2020-02-10','img/the_album.png',99,'NEW',1);
insert into album (id, name, price, date, image, inventory, status,artist_id)  values(2,'THE NEXT ALBUM',13.99,'2021-02-01','img/photo.png',15,'NEW',1);
insert into album (id, name, price, date, image, inventory, status,artist_id)  values(3,'THE FINAL ALBUM',19.99,'2021-05-05','img/final.png',3,'USED',2);
insert into album (id, name, price, date, image, inventory, status,artist_id) values(4,'THE ALBUM',9.99,'2020-02-10','img/the_album.png',99,'NEW',1);
insert into album (id, name, price, date, image, inventory, status,artist_id)  values(5,'THE NEXT ALBUM',13.99,'2021-02-01','img/photo.png',15,'NEW',1);
insert into album (id, name, price, date, image, inventory, status,artist_id)  values(6,'THE FINAL ALBUM',19.99,'2021-05-05','img/final.png',3,'USED',2);
insert into album (id, name, price, date, image, inventory, status,artist_id) values(7,'THE ALBUM',9.99,'2020-02-10','img/the_album.png',99,'NEW',1);
insert into album (id, name, price, date, image, inventory, status,artist_id)  values(8,'THE NEXT ALBUM',13.99,'2021-02-01','img/photo.png',15,'NEW',1);
insert into album (id, name, price, date, image, inventory, status,artist_id)  values(9,'THE FINAL ALBUM',19.99,'2021-05-05','img/final.png',3,'USED',2);



=======
INSERT INTO artist VALUES(3, 'USA', 'Taylor Swift');


insert into genre(id,name,description) values(1,'K-Pop','Funky pop music from Korea');
insert into genre(id,name,description) values(2,'Pop','Funky pop music from America');
insert into genre(id,name,description) values(3,'Funk','Its, just Funky music');


insert into album (id,name,price,date,image,inventory,status,artist_id,genre_id) values (1,'THE ALBUM',11.99,'2020-10-2','the_album.png',18,'NEW',1,1);
insert into album (id,name,price,date,image,inventory,status,artist_id,genre_id) values (2,'MAP OF THE SOUL: 7',12.99,'2020-5-12','map_soul.png',25,'NEW',2,1);
insert into album (id,name,price,date,image,inventory,status,artist_id,genre_id) values (3,'DDU DU DDU DU',13.99,'2019-1-18','photo.png',51,'NEW',1,1);
insert into album (id,name,price,date,image,inventory,status,artist_id,genre_id) values (4,'IDOL',14.99,'2019-9-5','final.png',2,'NEW',2,2);
insert into album (id,name,price,date,image,inventory,status,artist_id,genre_id) values (5,'TEE WEEZY',5.99,'2007-3-9','Album_1.png',8,'USED',3,2);

insert into song (id,name,price,inventory,artist_id,album_id) values (1,'HOW YOU LIKE THAT',0.99,12,1,1);
insert into song (id,name,price,inventory,artist_id,album_id) values (2,'CRAZY OVER YOU',0.99,15,1,1);
insert into song (id,name,price,inventory,artist_id,album_id) values (3,'LOVESICK GIRLS',0.99,80,1,1);
insert into song (id,name,price,inventory,artist_id,album_id) values (4,'PRETTY SAVAGE',0.99,16,1,1);
insert into song (id,name,price,inventory,artist_id,album_id) values (5,'DDU DU DDU DU',0.99,25,1,3);
insert into song (id,name,price,inventory,artist_id,album_id) values (6,'SEE U LATER',0.99,64,1,3);
insert into song (id,name,price,inventory,artist_id,album_id) values (7,'BOOMBAYAH',0.99,87,1,3);
insert into song (id,name,price,inventory,artist_id,album_id) values (8,'ON',0.99,95,2,2);
insert into song (id,name,price,inventory,artist_id,album_id) values (9,'EGO',0.99,32,2,2);
insert into song (id,name,price,inventory,artist_id,album_id) values (10,'DNA',0.99,34,2,2);
insert into song (id,name,price,inventory,artist_id,album_id) values (11,'IDOL',0.99,62,2,4);
insert into song (id,name,price,inventory,artist_id,album_id) values (12,'NOT TODAY',0.99,81,2,4);
insert into song (id,name,price,inventory,artist_id,album_id) values (13,'22',0.99,11,3,5);
insert into song (id,name,price,inventory,artist_id,album_id) values (14,'NEVER EVER',0.99,3,3,5);
insert into song (id,name,price,inventory,artist_id,album_id) values (15,'YOU BELONG WITH ME',0.99,1,3,5);
>>>>>>> Stashed changes
