import React from 'react';
import {Container, Header} from "semantic-ui-react";
import './App.css';
import Cartography from "./components/cartography/Cartography";

function App() {
  return (
    <Container className="App">
      <Header as='h1'>Timber WALL-E Simulator</Header>
      <Cartography />
    </Container>
  );
}

export default App;
