function handleForm() {
    var isValid = validateForm();

    if(isValid) {
        handleFormSubmit();
    }

    return isValid;
}

async function handleFormSubmit() {
    event.preventDefault();
    const form = event.currentTarget;
    const url = form.action;

    try {
        const formData = new FormData(form);
        const responseData = await postFormDataAsJson({ url, formData });
        showFile(responseData);

    } catch (error) {
        updateErrorMessage(true, "Error: provided json cannot be converted to pdf.");
    }
}

async function postFormDataAsJson({ url, formData }) {
	const plainFormData = Object.fromEntries(formData.entries());
	const formDataJsonString = JSON.stringify(plainFormData);

	const fetchOptions = {
		method: "POST",
		headers: {
              'Content-Type': 'application/json'
            },
		body: formData.get("jsonToConvert"),
	};

	const response = await fetch(url, fetchOptions)

	if (!response.ok) {
		const errorMessage = await response.text();
		throw new Error(errorMessage);
	}

	return response.blob();
}

function validateForm() {
  var x = document.forms["converter"]["jsonToConvert"].value;
  var converterError =  document.getElementById("converterError");

  if (x == "") {
    updateErrorMessage(true, "Json cannot be empty!");
   return false;
  } else {
    updateErrorMessage(false, "");
    return true;
  }
}

function updateErrorMessage(isError, message) {
    if(isError) {
        converterError.style.display = "block";
        converterError.innerHTML=message;
    } else {
        converterError.innerHTML="";
        converterError.style.display = "none";
    }
}

function showFile(blob){
    var newBlob = new Blob([blob], {type: "application/pdf"})
    const data = window.URL.createObjectURL(newBlob);

    var link = document.createElement('a');
    link.href = data;
    window.open(link);
}