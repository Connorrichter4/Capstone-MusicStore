insert into user (email,name, city, password, address, state, zipcode, credit_card, role) values ('user@user.com','user','new york' ,'password', '1234 apple st', 'NY', '12345', '123456789', 'ADMIN');
insert into user (email,name, city, password, address, state, zipcode, credit_card, role) values ('test@test.com', 'test', 'dallas','password', '1234 apple st', 'NY', '12345', '123456789', 'ADMIN');

insert into artist values(1,'Korea','BLACKPINK');
insert into artist values(2,'Korea','BTS');

insert into song (name, inventory, price, album_id, artist_id) values ('Good News',4, 10, 1, 1 );
insert into song (name, inventory, price, album_id, artist_id) values ('News',4, 10, 1, 2 );
insert into song (name, inventory, price, album_id, artist_id) values ('Alphabet Good News',4, 10, 1, 2 );
insert into song (name, inventory, price, album_id, artist_id) values ('bananas',4, 10, 1, 1 );

insert into genre (id, name, description) values (1, 'Pop', 'produced the most hits');
insert into genre (id, name, description) values (2, 'Country', 'Country music often consists of ballads and dance tunes with generally simple forms');


insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id) values(1,'THE ALBUM',9.99,'2020-02-10','img/the_album.png',99,'NEW',1,1);
insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(2,'THE NEXT ALBUM',13.99,'2021-02-01','img/photo.png',15,'NEW',1,1);
insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(3,'THE FINAL ALBUM',19.99,'2021-05-05','img/final.png',3,'USED',2,2);
insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id) values(4,'THE ALBUM',9.99,'2020-02-10','img/the_album.png',99,'NEW',1,2);
insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(5,'THE NEXT ALBUM',13.99,'2021-02-01','img/photo.png',15,'NEW',1,null);
insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(6,'THE FINAL ALBUM',19.99,'2021-05-05','img/final.png',3,'USED',2,null);
insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id) values(7,'THE ALBUM',9.99,'2020-02-10','img/the_album.png',99,'NEW',1,2);
insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(8,'THE NEXT ALBUM',13.99,'2021-02-01','img/photo.png',15,'NEW',1,1);
insert into album (id, name, price, date, image, inventory, status,artist_id,genre_id)  values(9,'THE FINAL ALBUM',19.99,'2021-05-05','img/final.png',3,'USED',2,null);


insert into shopping_cart (id, album_id, song_id, user_id ) values (1, 2, null, 1);
insert into shopping_cart (id, album_id, song_id, user_id ) values (2, null, 3, 1);
insert into shopping_cart (id, album_id, song_id, user_id ) values (3, 7, null, 2);
insert into shopping_cart (id, album_id, song_id, user_id ) values (4, 7, null, 1);

