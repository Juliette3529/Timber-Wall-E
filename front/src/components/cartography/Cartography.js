import React, {useEffect, useState} from 'react';
import './Cartography.css';
import obstacle from '../../images/obstacle.svg';
import tree from '../../images/tree.svg';
import blank from '../../images/blank.svg';
import robot from '../../images/robot.svg';
import * as d3 from "d3";

function Cartography({circuit, setCircuit, dataset}) {
    const cellSize = 16;

    // TODO: Remove this, as it is a test entry, and replace it with dataset variable
    const [data, setData] = useState(
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
    const columns = data.indexOf("\n");

    const d3Data = data.replace(/\n/g, "").toUpperCase();

    useEffect(() => {
        drawChart();
    }, []);

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

    const getXFromIndex = (i) => i % columns;
    const getYFromIndex = (i) => Math.floor(i / columns)

    const addPointToCircuit = (cellSymbol, cellIndex) => {
        if (cellSymbol !== "O") {
            return;
        }

        setCircuit(`${circuit}\n${getXFromIndex(cellIndex)} ${getYFromIndex(cellIndex)}`);
    }

    const drawChart = () => {
        const svg = d3
            .select("#Cartography")
            .append("svg")
            .attr("width", columns * cellSize)
            .attr("height", data.length / columns * cellSize)
            .attr("style", "outline: thin dashed black;")
        ;

        svg
            .selectAll()
            .data(d3Data)
            .enter()
            .append("svg:image")
            .attr("x", (d, i) => getXFromIndex(i) * cellSize)
            .attr("y", (d, i) => getYFromIndex(i) * cellSize)
            .attr("width", cellSize)
            .attr("height", cellSize)
            .attr("xlink:href", getCellImage)
            .attr("class", getCellClass)
            .on("click", addPointToCircuit)
        ;
    };

    return (
        <div id="Cartography" />
    );
}

export default Cartography;
