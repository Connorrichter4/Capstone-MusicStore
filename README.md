# Music Store

### To Do List

- Finish merging admin controller into other controllers
- incorporate genre controller with album, song controllers
- Shopping Cart:

  - create a shopping cart entity
  - create shopping cart controller

- Spring Security:

  - create userdetailsimpl
  - create web config file
  - encode user passwords

- jsps: ( to finalize )
  - shopping cart jsp
  - home page jsp
  - admin home jsp
  - create song jsp
  - edit song jsp
  - create album jsp
  - edit album jsp
  - create / edit artist jsp
  - create / edit genre jsp

### Entities & Attributes

![Er Diagram 2 Rough](https://user-images.githubusercontent.com/58124052/109669263-8e8daf80-7b37-11eb-8546-92de30eeabec.png)

- User

  - id
  - username (email)
  - password
  - Roles (required for Spring Security) (admin/user)
  - Shopping Cart (one to many)
  - address
  - state
  - zip
  - credit cards

- Albums

  - id
  - name
  - price
  - artist (id)
  - date
  - condition
  - image (url)
  - inventory
  - genre (id)
  - songs (id) (list)

- Genre

  - id
  - name
  - description

- Song

  - id
  - name
  - price
  - inventory
  - artist (id)
  - album (id)
  - genre (id)

- Artist

  - id
  - name
  - location
  - songs (id)
  - albums (id)

- Shopping Cart
  - songs (id)
  - albums (id)
  - user (id)

### Pages

Seed admin data

- permit all

  - /login
  - /signup
  - /home (show all albums)
  - /album/:id (show all songs in album)
  - /songs (show all songs)

- authenticate

  - /checkout

- authorization
  - /admin/products
  - /admin/product/edit/:id
  - /admin/product/create
  - /admin/product/delete/:id
  - /admin/customers
  - /admin/customers/edit/:id
  - /admin/customers/create
  - /admin/customers/delete/:id
