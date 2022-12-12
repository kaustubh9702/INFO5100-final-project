# APPLICATION ENGINEERING DEVELOPMENT

Hi! I'm your first Markdown file in **StackEdit**. If you want to learn about StackEdit, you can read me. If you want to play with Markdown, you can edit me. Once you have finished with me, you can create new files by opening the **file explorer** on the left corner of the navigation bar.


# Introduction

- Our project GVIDIA is a chip manufacturing and delivery application which aims to simulate the chip manufacturing process from procuring the raw materials to selling it to the customers.

- A semiconductor termed a chip acts as the mind of electronics. These chips are currently in an extremely tight supply and high demand scenario.

- The majority of companies that produce the raw resources for the projects also closed down as a result of the COVID 19 epidemic, along with the rest of the world. Orders increased in number as the ports started closing.

## Why Chip Manufacturing?

- From something as simple as an electric toothbrushes to something as complex as a car or a phone, almost everything we own includes a chip. The relevance of such chips may be challenged.

- A semiconductor termed a chip acts as the mind of electronics. These chips are currently in an extremely tight supply and high demand scenario.

- This shortage may lead to less Apple gadgets being manufactured, fewer automobiles, and higher prices for the currently available electronics.


## UML CLASS DIAGRAM


![enter image description here](https://i.imgur.com/PO0N51K.png)
## SEQUENCE DIAGRAM

![enter image description here](https://i.imgur.com/2T3HTbl.png)

## SUPPLY ENTERPRISE

Creates raw - materials bundles for the manufacturer in accordance with the purchase order. It is absorbed by Executive organization as well as the Union organization.

**Executive**: Receives requests for raw materials from the manufacturer and sends them to the union for sourcing. include the position of executive head.

Purchasing and labelling the bundles for shipment are handled by union. receives request for raw material sourcing from the executive organization. include the position of Union Leader.


**Source Raw Material**: The Wholesale Manager will make a request for raw material to a Executive head. Executive head will submit a request for raw resources to the Union Leader just on ground.


## MANUFACTURING ENTERPRISE

Produces the products for the Retail Enterprises to sell. It comprises three organizations: Wholesale organization, Product Development organization and Inventory organization, Product Development organization and Inventory organization.

***Wholesale***: Gets requests from the Product team for the raw materials and relays the request to the supplier. Consists of a Wholesale Manager role.

**Product Development**:  Creates products for sale in the inventory. Also places requests to the wholesale team when there’s a requirement for raw materials. Consists of a Product Developer role.

**Inventory**: Stores and keeps track of the products created and then passes it on to the retailer. Consists of an Inventory Manager role.

# MANUFACTURING ENTERPRISE - CONTINUED



**Raw Material Order Request**: Wholesale Manager will send a request to Supply for raw materials

**Product Raw Material Request**:  Product Developer will send a request to Wholesale Manager for  material for products

**Place Product in Inventory Request**: Inventory Manager will send in a request to Product  Development for products

**On Ground Request**: Retail Enterprise will send in a request to Inventory Manager for product

## RETAILER ENTERPRISE

Buys products from the manufacturer and sells them to the customer.

**Inventory**: Buys products from the manufacturer’s inventory to build its own retail inventory. Consists of an Inventory Manager role.

**Customer/Sales**: Customer can view the product and make a purchase. Consists of a Customer role.

On Ground: Inventory Manager will send in a request to Manufacturer for product

## LOGISTICS ENTERPRISE

Delivers goods from one place to another.

**On Ground:** Deals with delivery of goods via trains and trucks. Consists of a Delivery Man role.  Off Ground:  Deals with delivery of goods via airplanes and ships. Consists of Captain role.



**On Ground**: Will get request to ship from one enterprise to another via trains and trucks Off Ground: Will get request to ship from one enterprise to another via airplanes and ships

## Team Members



```
