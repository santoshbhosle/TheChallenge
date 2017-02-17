1. Download codebase
2. Import project in eclipse
3. Run Application.java as Java Application
4. Use Postman to test
	POST : http://localhost:8080/shops
			To add shop set raw body as below
			{"shopName":"Starbucks","shopLongitude":null,"shopLatitude":null,"shopAddress":{"number":null,"postCode":3000}}
			
	GET : http://localhost:8080/shops
			To see all added shops

	GET : http://localhost:8080/shops/shop
			To get shop list based on latitude and longitude set parameters shopLatitude and shopLongitude
		