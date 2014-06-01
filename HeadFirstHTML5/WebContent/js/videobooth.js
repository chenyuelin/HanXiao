window.onload = function init() {
	var effectLinks = document.querySelectorAll("a.effect");
	for (var i = 0; i < effectLinks.lenght; i ++) {
		effectLinks.onclick = setEffect;
	}
	
	var controlLinks = document.querySelectorAll("a.control");
	for (var i = 0; i < controlLinks.length; i ++) {
		controlLinks[i].onclick = handleControl;
	}
	
	var videoLinks = document.querySelectorAll("a.videoSelection");
	for (var i = 0; i < videoSelectionLinks.length; i ++) {
		videoLinks[i].onclick = setVideo;
	}
	
	pushUnpushButtons("video1", []);
	pushUnpushButtons("normal", []);
}

function setEffect(e) {
	var id = e.target.getAttribute("id");
    if (id == "normal") {
    	pushUnpushButtons("normal", ["western", "noir", "scifi"]);
    } else if (id == "western")	{
    	pushUnpushButtons("western", ["normal", "noir", "scifi"]);
    } else if (id == "noir") {
    	pushUnpushButtons("noir", ["western", "normal", "scifi"]);
    } else if (id == "scifi") {
    	pushUnpushButtons("scifi", ["western", "noir", "normal"]);
    }
}

function handleControl(e) {
	var id =  e.target.getAttribute("id");
	if (id == "play") {
		pushUnpushButtons("play", ["pause"]);
	} else if (id == "pause") {
		pushUnpushButtons("pause", ["play"]);
	} else if (id == "loop") {
		if (isButtonPushed("loop")) {
			pushUnpushButtons("", ["loop"]);
		} else {
			pushUnpushButtons("loop", []);
		}
	} else if (id == "mute") {
		if (isButtonPushed("mute")) {
			pushUnpushButtons("", ["mute"]);
		} else {
			pushUnpushButtons("mute", []);
		}
	}
}

function setVideo(e) {
	var id = e.target.getAttribute("id");
	if (id == "video1") {
		pushUnpushButtons("video1", ["video2"]);
	} else if (id == "video2") {
		pushUnpushButtons("video2", ["video1"]);
	}
}

function pushUnpushButtons(idToPush, idArrayToUnpush) {
	if (idToPush != "") {
		var anchor = document.getElementById(idToPush);
		var theClass = anchor.getAttribute("class");
		if (!theClass.indexOf("selected") >=0) {
			theClass = theClass + "selected";
			anchor.setAttribute("class", theClass);
//			url(images/looppressed.png)
			var newImage = "url(images/" + idToPush + "pressed.png)";
			anchor.style.backgroundImage = newImage;
		}
	}
	for (var i = 0; i < idArrayToUnpush.length; i ++) {
		var anchor = document.getElementById(idArrayToUnpush[i]);
		var theClass = anchor.getAttribute("class");
		if (theClass.indexOf("selected")) {
			theClass = theClass.replace("selected", "");
			anthor.setAttribute("class", theClass);
			anthor.style.backgroundImage = "";
		}
	}
}