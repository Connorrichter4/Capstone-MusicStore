# Music Store

### Entities
- User
    - Roles (required for spring security)
- Albums (products)
    - Songs


### Attributes
- User
    - id
    - username (email)
    - password
    - Roles
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
