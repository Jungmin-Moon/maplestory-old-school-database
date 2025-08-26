document.addEventListener('DOMContentLoaded', init, false);

let mobName, mobLevel, mobEXP, mobLocationOne, mobLocationTwo;

function init() {
	mobName = document.querySelector('#mobName');
	mobLevel = document.querySelector('#mobLevel');
	mobEXP = document.querySelector('#mobEXP');
	mobLocationOne = document.querySelector('#mobLocationOne');
	mobLocationTwo = document.querySelector('#mobLocationTwo');
	
	let elems = Array.from(document.querySelectorAll('#mobForm input'));
	elems.forEach(e => e.addEventListener('input', handleChange, false));
	
	let cached = getForm();


	if (cached) {
		mobName.value =cached.mobName;
		mobLevel.value = cached.mobLevel;
		mobEXP.value = cached.mobEXP;
		mobLocationOne.value = cached.mobLocationOne;
		mobLocationTwo.value = cached.mobLocationTwo;
		onLoad(cached);
	}
}


function handleChange(e) {
	console.log('handleChange');
	
	let form = {};
	form.mobName = mobName.value;
	form.mobLevel = mobLevel.value;
	form.mobEXP = mobEXP.value;
	form.mobLocationOne = mobLocationOne.value;
	form.mobLocationTwo = mobLocationTwo.value;
	
	
	saveForm(form);
}


function saveForm(form) {
	let f = JSON.stringify(form);
	window.localStorage.setItem('form', f);
}

function getForm() {
	let f = window.localStorage.getItem('form');
	
	if (f) {
		return JSON.parse(f);
	}
}


function onLoad(cached) {
	document.getElementById('mobName').value = cached.mobName;
	document.getElementById('mobLevel').value = cached.mobLevel;
	document.getElementById('mobEXP').value = cached.mobEXP;
	document.getElementById('mobLocationOne').value = cached.mobLocationOne;
	document.getElementById('mobLocationTwo').value = cached.mobLocationTwo;
} 
