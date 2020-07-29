import React, {useEffect, useState} from 'react';
import './Cartography.css';
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

    const getXFromIndex = (i) => i % columns;
    const getYFromIndex = (i) => Math.floor(i / columns)

    const addPointToCircuit = (cellSymbol, i) => {
        if (cellSymbol !== "O") {
            return;
        }

        setCircuit(`${circuit}\n${getXFromIndex(i)} ${getYFromIndex(i)}`);
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
            .append("rect")
            .attr("x", (d, i) => getXFromIndex(i) * cellSize)
            .attr("y", (d, i) => getYFromIndex(i) * cellSize)
            .attr("width", cellSize)
            .attr("height", cellSize)
            .attr("fill", getCellColor)
            .attr("class", (d) => d === "O" ? "tree" : "")
            .on("click", addPointToCircuit)
        ;

        svg
            .selectAll()
            .data(d3Data)
            .enter()
            .append("svg")
            .attr("src", "./obstacle.svg")
        ;
    };

    return (
        <div id="Cartography" />
    );
}

export default Cartography;
