import React, {useEffect} from 'react';
import './Cartography.css';
import obstacle from '../../res/images/obstacle.svg';
import tree from '../../res/images/tree.svg';
import blank from '../../res/images/blank.svg';
import robot from '../../res/images/robot.svg';
import * as d3 from "d3";

/**
 *
 * @param cartography {CartographyModel}
 * @param wallE {WallEModel}
 * @returns {JSX.Element}
 * @constructor
 */
function Cartography({cartography, wallE}) {
    const cellSize = 16;

    const getCellImage = (cellType) => {
        switch (cellType) {
            case "O": return tree;
            case "X": return obstacle;
            case "D": return blank; // TODO create a "starting point" image
            default: return blank;
        }
    };
    const getCellClass = (cellType) => {
        switch (cellType) {
            case "O": return "tree";
            case "X": return "obstacle";
            case "D": return "start";
            default: return "";
        }
    };

    const drawChart = () => {
        let svg = d3.select('#Cartography > svg');

        // Tests if the chart has already been drawn, and erases it if needed.
        if (svg._groups[0][0] !== null) {
            svg.remove();
        }

        svg = d3
            .select("#Cartography")
            .append("svg")
            .attr("width", cartography.width * cellSize)
            .attr("height", cartography.height * cellSize)
            .attr("style", "outline: thin dashed black;")
        ;

        svg
            .selectAll()
            .data(cartography.plotContent)
            .enter()
            .append("svg:image")
            .attr("x", (d, i) => cartography.getXFromIndex(i) * cellSize)
            .attr("y", (d, i) => cartography.getYFromIndex(i) * cellSize)
            .attr("width", cellSize)
            .attr("height", cellSize)
            .attr("xlink:href", getCellImage)
            .attr("class", getCellClass)
        // .on("click", addPointToCircuit) // TODO
        ;

        svg
            .selectAll()
            .data([[wallE.xPos, wallE.yPos]])
            .enter()
            .append("svg:image")
            .attr("x", (d) => d[0] * cellSize)
            .attr("y", (d) => d[1] * cellSize)
            .attr("width", cellSize)
            .attr("height", cellSize)
            .attr("xlink:href", robot)
            .attr("class", "robot")
        // .on("click", addPointToCircuit) // TODO
        ;
    };

    useEffect(() => {
        drawChart();
    }, [wallE]);

    return (
        <div id="Cartography" />
    );
}

export default Cartography;
