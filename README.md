# shopinfo
Android project Spring 2020

## project members
- Sai Naveen Bhargava Gajavalli
- Pranneth Reddy Kalluri
- Pavan Sai Kumar Reddy Kamjula
- Chaitanya Popuri

## Description
The main mission of this app is to inform people who are interested in seeking information about the availability of product, quantity of the product and the shop timings, discounts on the products. 
This app serves a very helpful communication between the customers and the Sellers where through this app the Sellers will be able to address and ease the customer’s problems which they daily encounter like.
1.	Before they leave their house often customers think if the product is available at the store or not?
2.	Customers can search the shops based on city and categoery.
3.	If the product is available and if the customers want to make a bulk purchase, Is there sufficient quantity available at the store?
4.	Any discounts available on the products.
5.	Sellers can send email’s to the customers who are subscribed to their shops.
6.	Customer can call the sellers for further information through the app.

So with this app all the above issues of the customers are resolved by providing a “user-friendly and “easy to navigate “app.

## Application Information:
Test Credentials: There is no need of test credentials, You have to create two accounts namely for seller and customer.

## Sequence Information:
1. When the app launches main activity appears. There is a login button on the top near the menu.
2. On Clicking the login button login activity appears.
3. Click sign up button. On clicking sign up button user is directed to regestration page.
4. Click the Seller regestration button. On clicking seller regestration button user is directed to seller regestration page. Here the      user has to enter the details. In this page the address field should be given as "maryville" or "kansas". After filling all the          fields click the regester button. On clicking the regester button the field values are updated in the firebase database and the user    will be directed to login page.
5. Now login as a seller with the above regestration details. On logging in as a seller the user will be directed to SellerActivity        page. Here the user can update fields like availability, products, quantity, Discount message. Click the update button to update the    fields into the database. Now logout of the sellerActivity page. User will be directed to login page.
6. Click sign up button. On clicking sign up button user is directed to regestration page.
7. Click the customer regestration button. On clicking customer regestration button user is directed to customer regestration page. Here    the user has to enter the details. After filling all the fields click the regester button. On clicking the regester button the field    values are updated in the firebase database and the user will be directed to login page.
8. Now login as a customer with the above regestration details. On logging as a customer user can see a spinner to filter the cities.
   select the city as given in the seller regestration.
9. On selecting the city user can see the shops listed under that city. Click on the shop to view the details.
10. There is a call button at the bottom. On clicking the call button the user is directed to a call activity where he can call the     seller.

## Supported Devices.
1. Android 5.0 (API 21): Lollipop: minSdkVersion.
2. Android 5.1 (API 22): Lollipop
3. Android 6.0 (API 23): MarshMallow
4. Android 7.0 (API 24): Nougat
5. Android 7.1 (API 25): Nougat
6. Android 8.0 (API 26): Oreo
7. Android 8.1.0 (API 27): Oreo
8. Android 9.0 (API 28): Pie
9. Android 10.0 (API 29): targetSdkVersion,compileSdkVersion
