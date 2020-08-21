var numberOfSquare = 6;
var colors = generateRandomColor(numberOfSquare);
var pickedColor = pickColor();
var squares = document.querySelectorAll(".square");
var colorDisplay = document.getElementById('colorDisplay');
var message = document.querySelector("#message");
var h1 = document.querySelector("h1");
var resetButton = document.querySelector("#reset");
var easyBtn = document.querySelector("#easyBtn");
var hardBtn = document.querySelector("#hardBtn");

easyBtn.addEventListener("click", function(){
	easyBtn.classList.add("selected");
	hardBtn.classList.remove("selected")
	numberOfSquare = 3;
	colors = generateRandomColor(numberOfSquare);
	pickedColor = pickColor();
	colorDisplay.textContent = pickedColor;
	for (var i = 0; i < squares.length; i++) {
		if (colors[i]) {
		squares[i].style.background = colors[i];
		}
		else {
			squares[i].style.display = "none";
		}
	}
});

hardBtn.addEventListener("click", function(){
	hardBtn.classList.add("selected");
	easyBtn.classList.remove("selected");
	numberOfSquare = 6;
	colors = generateRandomColor(numberOfSquare);
	pickedColor = pickColor();
	colorDisplay.textContent = pickedColor;
	for (var i = 0; i < squares.length; i++) {
		squares[i].style.background = colors[i];
		squares[i].style.display = "block";
	}
});


resetButton.addEventListener("click", function(){
	colors = generateRandomColor(numberOfSquare);
	pickedColor = pickColor();
	colorDisplay.textContent = pickedColor;
	this.textContent = "New Colors"
	message.textContent = "";
	for (var i = 0; i < squares.length; i++) {
		squares[i].style.background = colors[i];
	}
	h1.style.background = "steelblue";
});

colorDisplay.textContent = pickedColor;

for (var i = 0; i < squares.length; i++) {
	squares[i].style.background = colors[i];
	squares[i].addEventListener("click", function(){
		var clickedColor = this.style.background;
		if (clickedColor === pickedColor) {
			message.textContent = "Correct!";
			resetButton.textContent = "Play Again";
			changeColor(clickedColor);
			h1.style.background = clickedColor;
		}
		else {
			this.style.background ="#232323";
			message.textContent = "Try Again";
		}
	});
}

function changeColor(color){
	for (var i = 0; i < squares.length; i++) {
		squares[i].style.background = color;
	}
}
function pickColor(){
	var random = Math.floor(Math.random() * colors.length);
	return colors[random];
}
function generateRandomColor(num) {
	var arr = [];

	for (var i = 0; i < num; i++) {
		arr.push(randomColor());
	}

	return arr;
}
function randomColor() {
	var r = Math.floor(Math.random() * 256);	
	var g = Math.floor(Math.random() * 256);
	var b = Math.floor(Math.random() * 256);
	return "rgb(" + r + ", " + g + ", " + b + ")"
}

