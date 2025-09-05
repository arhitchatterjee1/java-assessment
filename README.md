# Promotion Engine

## Overview

This is a simple promotion engine implemented via java language. the benefits of this 
have
- Adding Products with SKU and Price
- Adding Items in the Cart
- applying promotion
  - Single Promotion will use when you are trying to buy individual items(e.g: A for 5 qty)
  - Combinational Promotion will use when you are trying to buy combined item(e.g c and D)
---

## Working Procedure
- after running the project you need to put total num of skus
- you need to put skus name and price
- you need to put qty of sku
- after applying the promotion as per the business rule, it will gives total price.
### Inputs
1. **Products** - Each product has a `name` and a `unit price`.
2. **Promotions** - Special offer applied in products.
- **individual items promotion**:
```
3 A's for 130 (instad of 150)
2 B's for 45 (instad of 60)
```
- **Combo Promotion**
```
C+D for 30 (instad of 35)
```
3. **cart Items** -user adds quantities of product to the cart
## Outputs
```
Enter the numbers of products
4
Enter Product Name
A
Enter the price of A the product
50
Enter Product Name
B
Enter the price of B the product
30
Enter Product Name
C
Enter the price of C the product
20
Enter Product Name
D
Enter the price of D the product
15
how many products A are there?
1
how many products B are there?
1
how many products C are there?
1
how many products D are there?
0
final total Price: 100.0
```
