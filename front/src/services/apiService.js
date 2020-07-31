let url = 'http://localhost:8090/move';
let myBody = {
    "positionX": 1,
    "positionY": 1
  }
const functions = { postMove : async () => {
    const response = await fetch(url, {
      method: 'POST',
      body: myBody,
      headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin' : '*'
      }
    });
    const myJson = await response.json(); 
    console.log(myJson);
  }
}

export default functions;