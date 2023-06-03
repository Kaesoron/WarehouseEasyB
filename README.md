# WarehouseEasyB
This is a test project.
This is a REST-application, so it consumes and produces JSON.

Made with Spring, using H2 in-memory database.

DESCRIPTION:
A store that sells computers and accessories with the following product type: 
  ● Personal computers(PCs)
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

HOW TO USE:
1. Run the application;
2. Opening http://localhost:8080 in browser will return the list of products;
3. http://localhost:8080/777 will open a details for product with id=777 (if exists). 
The same will work with http://localhost:8080/hdd/777 directory if the product is hdd.
3. TO VIEW BY TYPE:
   http://localhost:8080/hdds will return a list of HDD, as well for other types:
   http://localhost:8080/pcs returns a list of PCs
   http://localhost:8080/notebooks returns a list of Notebooks
   http://localhost:8080/monitors returns a list of Monitors
4. TO ADD a product, make POST with JSON to one of the category hyperlinks (above)
5. TO EDIT a product, make PUT with JSON to one of the category hyperlinks

Here is an example JSON for HDD:

{
"id": 1000,
"commodityType": "HDD",
"seriesNumber": 100500,
"manufacturer": "SOME COMPANY",
"price": 1000.0,
"quantity": 10000,
"volume": 1000,
"volumeMeasure": "GIGABYTES"
}