# Music Store Capstone Project

## Background

- An online product catalog that can be browsed: The work starts with adding many new product catalog features which includes displaying categories, products, and product details.

- Searching the Catalog: For the visual part, a text box is used in which the visitor can enter one or more words to search through the product catalog. In Music CD Shop,the words entered by the visitor are searched for in the products’ names and descriptions. Also, the user can search for a particular song by entering the title, artist,style, format and the price range.

- A Custom Shopping Cart and checkout: A custom shopping basket is implemented, which stores its data into the local database. Also a “shopping cart summary control” is created that shows up in every catalog page except the shopping cart page.

- Handling Customer Accounts: In customer account system, details such as credit card numbers are stored in a database so that customers don’t have to retype this information each time they place an order. Customers can log in via a login page or dialog box to get access to secured areas of the web site. Once logged in, the WebApplication remembers the customer until the customer logs out (either manually via a Log Out button or automatically, if the session times out ora server error occurs).All secure pages in a Web Application need to check whether a customer is logged in before allowing access.

- Catalog Administration: This administrative interface is implemented for easy management of the web store data. The catalog administration page allows the administrator to:
  - Add or remove genres, and update the details of existing genres
  - View and manage the categories that belong to a genre• Manage the list of products in a specific category, and edit product details
  - Assign an existing product to an additional, or move it to another category
  - Remove a product from a category or delete the product from the catalog• Manage orders by updating their status

### Recommended technologies:

- Spring boot
- Java 8
- MySQL database
- Spring Data JPA
- JSP
- Servlets
- Bootstrap

## Planning

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

## Examples

### Login Page

![login](https://user-images.githubusercontent.com/58124052/110174881-74b5cc00-7dc6-11eb-8278-6ccdb432470f.png)

### Sign Up Page

![signup](https://user-images.githubusercontent.com/58124052/110174884-75e6f900-7dc6-11eb-9a41-4d98d4515daa.png)

### Home Page

### Album Id Page

### Song Id Page

### Artist Id Page

### Search Results

### Shopping Cart Page

### Completed Checkout Page

### Admin Home Page

### Admin Album Create

### Admin Artist Create

### Admin Song Edit

### Admin Genre Edit

### Admin Customer Page

### Admin Customer Edit
