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
 * @returns {JSX.Element}
 * @constructor
 */
function Cartography({cartography}) {
    const cellSize = 16;

    const getCellImage = (cellType) => {
        switch (cellType) {
            case "O": return tree;
            case "X": return obstacle;
            case "D": return robot;
            default: return blank;
        }
    };
    const getCellClass = (cellType) => {
        switch (cellType) {
            case "O": return "tree";
            case "X": return "obstacle";
            case "D": return "robot";
            default: return "";
        }
    };

    const drawChart = () => {
        const svg = d3
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
    };

    useEffect(() => {
        drawChart();
    });

    return (
        <div id="Cartography" />
    );
}

export default Cartography;
