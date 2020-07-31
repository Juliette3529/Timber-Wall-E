let url = 'http://localhost:8090/move';
let myBody = {
    "positionX": '1.0',
    "positionY": '1.0'
  } 
const functions = { postMove : async () => {
    const response = await fetch(url, {
      method: 'POST',
      body : JSON.stringify( myBody),
      headers: {
        'Content-Type': 'application/json'
      }
    });
    const myJson = await response.json(); 
    console.log(myJson);
    console.log('dfvqdfvqfvqfvs');
    //ici traitement ou ailleurs d'ailleurs juste return le myJSON
    return myJson
  }
}

export default functions;