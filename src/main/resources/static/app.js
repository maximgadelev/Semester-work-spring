let stompClient = null;

function connect() {
    let socket = new SockJS("/chat");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe("/messages", function (message) {
            let json = JSON.parse(message.body);
            showGreeting(json['message']);
        })
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    console.log('Disconnected');
}


function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

function sendMessage(message) {
    let json = {
        "message": message
    }

    stompClient.send("/chat/message", {}, JSON.stringify(json));
    document.getElementById('message').value = '';

}
