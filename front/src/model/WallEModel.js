// WallEModel's constructor
function WallEModel(xPos, yPos, powerConsumption = 0, isMeasuring = false) {
    this.xPos = xPos;
    this.yPos = yPos;

    this.powerConsumption = powerConsumption;
    this.isMeasuring      = isMeasuring;
}

// WallEModel's methods
WallEModel.prototype = {
    move: function(positionX, positionY) {
        this.xPos = positionX;
        this.yPos = positionY;
    }
}

export default WallEModel;