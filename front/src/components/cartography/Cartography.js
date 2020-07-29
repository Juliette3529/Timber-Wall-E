import React, {useEffect, useState} from 'react';
import './Cartography.css';
import * as d3 from "d3";

function Cartography({columns}) {
    // TODO: Remove this, as it is a test entry
    const [trees, setTrees] = useState(
        "D-------------------------------------------------" +
        "|   O     O    O     O    O     O   O     O   O  |" +
        "|                                                |" +
        "| O    O    O      O   O      O     XXX   O      |" +
        "|     XXXXXX                                     |" +
        "|   O       O      XXXX       O  X        O      |" +
        "|       O        O    XXXX          X O       O  |" +
        "|                                                |" +
        "|   O     O    O     O    O  X  O   O     O   O  |" +
        "|                                                |" +
        "| O    O    O      O   O      X     O     O      |" +
        "--------------------------------------------------"
    );
    columns = 50;

    useEffect(() => {
        drawChart();
    }, []);

    const getCellColor = (cellType) => {
        switch (cellType) {
            case "O": return "#0F0";
            case "|":
            case "-": return "#FFF";
            case "X": return "#F00";
            case "D": return "#F0F";
            default: return "#FFF";
        }
    };

    const drawChart = () => {
        const svg = d3
            .select("#cartography")
            .append("svg")
            .attr("width", columns * 16)
            .attr("height", trees.length / columns * 16)
            .attr("style", "outline: thin dashed black;")
        ;

        svg
            .selectAll("rect")
            .data(trees.replace(/\n/g, ""))
            .enter()
            .append("rect")
            .attr("x", (d, i) => 16 * (i % columns))
            .attr("y", (d, i) => 16 * Math.floor(i / columns))
            .attr("width", 16)
            .attr("height", 16)
            .attr("fill", getCellColor)
        ;
    };

    return (
        <div id="cartography" />
    );
}

export default Cartography;
