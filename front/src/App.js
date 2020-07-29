import React from 'react';
import {Button, Container, Segment, Image, Grid} from "semantic-ui-react";
import './App.css';
import logo from '../src/logowithoutslogan.svg';

function App() {
  const boomer = () => {
    alert("OK Boomer");
  };

  return (
    <Container fluid="1">
      <Segment.Group>
        <Segment><Image src={logo} size='tiny'/></Segment>
        <Segment>
         <Grid  columns={3} aligned>
            <Grid.Row >
              <Grid.Column >
                  <button class="ui button basic massive no-border" size="huge"><i class="angle left icon fitted big"></i></button>
                  </Grid.Column>
                    <Grid.Column textAlign='center'>
                      <h2>Nom de la map</h2>
                    </Grid.Column>
                    <Grid.Column textAlign='right'>
                  <button centered class="ui button basic massive no-border" size="huge"><i class="angle right icon fitted big"></i></button>
              </Grid.Column>
            </Grid.Row>
            </Grid>
          <Grid verticalAlign='middle' columns={16} centered>
            <Grid.Row>
              <Grid.Column>
              <button class="ui button no-border basic" ><i class="arrow left icon icon-orange huge"></i></button>
              </Grid.Column>
              <Grid.Column >
              <button class="ui button no-border basic"><i class="arrow up icon icon-orange huge"></i></button>
                <br />
                <button class="ui button no-border basic"><i class="circle icon icon-orange massive"></i></button>
                <br/>
                <button class="ui button no-border basic"><i class="arrow down icon icon-orange huge"></i></button>
              </Grid.Column>
              <Grid.Column>
              <button class="ui button no-border basic"><i class="arrow right icon icon-orange huge"></i></button>
              </Grid.Column>
            </Grid.Row>
          </Grid>
        </Segment>
        <Segment>
          <Grid >
            <Grid.Row verticalAlign='middle' columns={5} centered>
              <Grid.Column floated='left' width={5}>
                <Image src='https://react.semantic-ui.com/images/wireframe/paragraph.png' />
              </Grid.Column>*
              <Grid.Column></Grid.Column>
              <Grid.Column floated='right' width={5}>
                <Image src='https://react.semantic-ui.com/images/wireframe/paragraph.png' />
              </Grid.Column>
            </Grid.Row>
          </Grid>
        </Segment>
        <Segment>
          
        </Segment>
      </Segment.Group>
    </Container>

  );
}

export default App;
