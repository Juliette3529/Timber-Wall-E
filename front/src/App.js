import React, {useEffect, useState} from 'react';
import {Container, Header, TextArea} from "semantic-ui-react";
import './App.css';
import Cartography from "./components/cartography/Cartography";

function App() {
    const [circuit, setCircuit] = useState("1 1\n2 2");

    useEffect(() => {}, [circuit])

  return (
    <Container className="App">
      <Header as='h1'>Timber WALL-E Simulator</Header>

      <Cartography circuit={circuit} setCircuit={setCircuit} />

        <TextArea
            placeholder='Circuit'
            value={circuit}
            onChange={({target}) => setCircuit(target.value)}
        />
    </Container>
  );
}

export default App;
