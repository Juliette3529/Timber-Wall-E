import React, {useState} from 'react';
import {Icon, Button, Container, Segment, Image, Grid, Card} from "semantic-ui-react";
import './Dashboard.css';
import logo from '../res/images/logowithoutslogan.svg';
import battery from '../res/images/battery.svg';
import Cartography from "../components/cartography/Cartography";
import CartographyModel from "../model/CartographyModel";
import apiService from "../services/apiService.js";
import WallEModel from "../model/WallEModel";

function Dashboard() {
    const cartography = new CartographyModel(
        "Forêt Kokiri",
        "D-------------------------------------------------\n" +
        "|   O     O    O     O    O     O   O     O   O  |\n" +
        "|                                                |\n" +
        "| O    O    O      O   O      O     XXX   O      |\n" +
        "|     XXXXXX                                     |\n" +
        "|   O       O      XXXX       O  X        O      |\n" +
        "|       O        O    XXXX          X O       O  |\n" +
        "|                                                |\n" +
        "|   O     O    O     O    O  X  O   O     O   O  |\n" +
        "|                                                |\n" +
        "| O    O    O      O   O      X     O     O      |\n" +
        "--------------------------------------------------"
    );

    const startIndex = cartography.plotContent.indexOf("D");

    const [wallE, setWallE] = useState(new WallEModel(cartography.getXFromIndex(startIndex), cartography.getYFromIndex(startIndex)));

    const moveWallE = (positionX, positionY) => {
        if (positionX < 0 || positionY < 0 || positionX >= cartography.width || positionY >= cartography.height) {
            return false;
        }

        if (cartography.getCellFromCoords(positionX, positionY) === "X") {
            return false; // TODO add visual feedback of error
        }

        apiService.postMove(positionX, positionY)
            .then((moveResult) => {
                if (!moveResult) return;
                wallE.move(moveResult.positionX, moveResult.positionY);
                wallE.powerConsumption = moveResult.batteryUsage;
                setWallE(new WallEModel(wallE.xPos, wallE.yPos, wallE.powerConsumption, wallE.isMeasuring));
            });
    }

    return (
        <Container fluid>
            <Segment.Group>
                <Segment id="header"><Image src={logo} size='tiny'/></Segment>

                <Segment id="driver">
                    <Grid columns={3}>
                        <Grid.Row centered>
                            <Cartography cartography={cartography} wallE={wallE}/>
                        </Grid.Row>

                        <Grid.Row verticalAlign='middle'>
                            <Grid.Column>
                                <Button basic><Icon name="angle left" size="huge"/></Button>
                            </Grid.Column>
                            <Grid.Column textAlign='center'>
                                <h2>{cartography.name}</h2>
                            </Grid.Column>
                            <Grid.Column textAlign='right'>
                                <Button basic><Icon name="angle right" size="huge"/></Button>
                            </Grid.Column>
                        </Grid.Row>
                    </Grid>

                    <Grid verticalAlign='middle' columns={3}>
                        <Grid.Row centered>
                            <Grid.Column textAlign="center">
                                <Icon name="arrow up" color="orange" size="huge" onClick={() => moveWallE(wallE.xPos, wallE.yPos-1)}/>
                            </Grid.Column>
                        </Grid.Row>

                        <Grid.Row>
                            <Grid.Column textAlign="right" width={6}>
                                <Icon name="arrow left" color="orange" size="huge" onClick={() => moveWallE(wallE.xPos-1, wallE.yPos)}/>
                            </Grid.Column>
                            <Grid.Column textAlign="center" width={4}>
                                <Icon name="circle" color="orange" size="huge"/>
                            </Grid.Column>
                            <Grid.Column width={6}>
                                <Icon name="arrow right" color="orange" size="huge" onClick={() => moveWallE(wallE.xPos+1, wallE.yPos)}/>
                            </Grid.Column>
                        </Grid.Row>

                        <Grid.Row centered>
                            <Grid.Column textAlign="center">
                                <Icon name="arrow down" color="orange" size="huge" onClick={() => moveWallE(wallE.xPos, wallE.yPos+1)}/>
                            </Grid.Column>
                        </Grid.Row>
                    </Grid>
                </Segment>

                <Segment id="robot-stats">
                    <Grid >
                        <Grid.Row verticalAlign='middle' columns={5} centered>
                            <Grid.Column floated='right' width={5}>
                                <Card>
                                    <Image src={battery} size='tiny'/>
                                    <Card.Content>
                                        <Card.Header>Power Consumption</Card.Header>
                                        <Card.Description>
                                            {wallE.powerConsumption} Watts
                                        </Card.Description>
                                    </Card.Content>
                                    <Card.Content extra>
                                    </Card.Content>
                                </Card>
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

export default Dashboard;
