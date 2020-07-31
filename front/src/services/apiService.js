let url = 'http://localhost:8090/move';

const functions = {
    postMove : async (positionX, positionY) => {
        const response = await fetch(url, {
            method: 'POST',
            body : JSON.stringify({positionX, positionY}),
            headers: {
                'Content-Type': 'application/json'
            }
        });

        return await response.json();
    }
}

export default functions;