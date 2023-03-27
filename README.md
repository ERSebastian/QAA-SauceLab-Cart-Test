Testing of Cart and Checkout functionality at SauceLab

In this case the idea was to add an item to the Cart, follow the checkout and validate the end of the operation.
For this I coded the login form, used Actions to add an item to the cart and validate that item with asserts. If this is correct we proceed to the checkout and fill the personal data form, then click on continue and validate again that the cart has the correct item in it. Once we get to the last part I check if the message contains the word "thank you" to validate the purchase.
