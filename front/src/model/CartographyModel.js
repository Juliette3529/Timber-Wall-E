/**
 * @param name {string} name of the cartography
 * @param plotContent {string} ascii representation of the plot
 * @constructor
 */
function CartographyModel(name, plotContent) {
    this.name = name;

    this.width = plotContent.indexOf('\n'); // Equals to the length of the first line
    this.height = (plotContent.match(/\n/g) || []).length + 1; // Equals to the number of lines of the file, plus 1

    // Flattens the string into 1 line to make usage easier
    this.plotContent = plotContent.replace(/\n/g, "").toUpperCase();
}

CartographyModel.prototype = {
    getXFromIndex: function(i) { return i % this.width; },
    getYFromIndex: function(i) { return Math.floor(i / this.width); }
}

export default CartographyModel;