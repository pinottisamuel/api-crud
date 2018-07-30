function getClients() {
		
//	// Utilizando XMLHttpRequest 
//	var clients = new XMLHttpRequest;	 
//	
//	clients.open("GET", "http://localhost:9000/api-clients/clients");
//	 
//	clients.addEventListener("load", function(){
//	 
//		var clientsJSON = JSON.parse(clients.responseText);
//	 
//		clientsJSON.forEach(function(client){ 
//			createTableElement(client); 
//		}); 
//	})
//	 
//	clients.send();
	
	// Utilizando fetch
	fetch("http://localhost:9000/api-clients/clients")
		.then(response => response.json()
				.then(function(data){
					data.forEach(function(client){
						createTableElement(client);
					})
				}));
}

function createTableElement(client) {

	var clientTr = document.createElement("tr");
	var codeTd = document.createElement("td");
	var nameTd = document.createElement("td");
	var actionTd = document.createElement("td");
	
	var btn = document.createElement("BUTTON");
	var btnText = document.createTextNode("DELETAR");
	
	btn.appendChild(btnText);
	btn.classList.add("btn-danger");
	btn.classList.add("btn-delete");
	
	var classButton = document.querySelectorAll(".btn-delete");
	
	classButton.forEach(function(clientBtn){
		clientBtn.addEventListener("click", function(){
			deleteClient(client.id);
		})
	});		

	codeTd.textContent = client.id;
	nameTd.textContent = client.name;
	actionTd.appendChild(btn);

	clientTr.appendChild(codeTd);
	clientTr.appendChild(nameTd);
	clientTr.appendChild(actionTd);

	var table = document.querySelector("#table-clients");
	table.appendChild(clientTr);
}