# WarehouseEasyB
This is a test project made for electronics shop.
This is a REST-application, so it consumes and produces JSON.

Made with Spring, using H2 in-memory database.

A store that sells computers and accessories with the following product type: 
  ● Desktops 
  ● Notebooks 
  ● Monitors 
  ● Hard Drives 

Each product has the following properties: 
  ● Serial number 
  ● Manufacturer 
  ● Price 
  ● Number of units in stock beeches are divided by size: 13, 14, 15, 17 inches 
  ● Monitors have a diagonal 
  ● Hard disks and have a capacity 

Having methods that perform:
1. Adding a product 
2. Editing a product 
3. Viewing all existing products by type 
4. Viewing a product by ID

HOW TO START:
1. Run the application;
2. Open http://localhost:8080/ in browser will return the list of products;
3. http://localhost:8080/hdd will return a list of HDD, as well for other types:
   http://localhost:8080/pc
4. http://localhost:8080/notebook
5. http://localhost:8080/monitor
4. ss