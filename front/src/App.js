import React from 'react';
import {Button, Container, Header} from "semantic-ui-react";
import './App.css';

function App() {
  const boomer = () => {
    alert("OK Boomer");
  };

  return (
    <Container className="App">
      <Header as='h1'>Timber WALL-E Simulator</Header>
      <Button onClick={boomer}>React Semantic UI is installed :D</Button>
    </Container>
  );
}

export default App;
