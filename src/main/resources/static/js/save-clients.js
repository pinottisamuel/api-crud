var buttonSave = document.querySelector("#save-client");
buttonSave.addEventListener("click", function(){
	event.preventDefault();
})

function saveClient() {
	
	var client = new FormData();
	client.append("name", document.querySelector("#name").value);
	
	fetch("http://localhost:9000/api-clients/clients", {
		method: "POST",
		body: client
	});
}