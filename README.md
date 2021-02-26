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