insert into user (email, password, address, state, zipcode, credit_card, role) values ('user@user.com','password', '1234 apple st', 'NY', '12345', '123456789', 'admin');

insert into user (email, password, address, state, zipcode, credit_card, role) values ('test@test.com','password', '1234 banana st', 'NY', '12345', '987654321', 'admin');

insert into artist values (1,'CA', 'Mac Miller' );
insert into artist values(2,'Korea','BLACKPINK');
insert into artist values(3,'Korea','BTS');
insert into song (name, inventory, price, album_id, artist_id) values ('Good News',4, 10, 1, 1 );
insert into album (id, name, price, date, image, inventory, status) values(1,'THE ALBUM',9.99,'2020-02-10','img/BLACKPINK-_The_Album.png',99,'NEW');
insert into album (id, name, price, date, image, inventory, status)  values(2,'THE NEXT ALBUM',13.99,'2021-02-01','img/photo.png',15,'NEW');
insert into album (id, name, price, date, image, inventory, status)  values(3,'THE FINAL ALBUM',19.99,'2021-05-05','img/final.png',3,'USED');

