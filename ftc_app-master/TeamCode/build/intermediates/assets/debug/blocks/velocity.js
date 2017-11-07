/**
 * @fileoverview FTC robot blocks related to Velocity.
 * @author lizlooney@google.com (Liz Looney)
 */

// The following are generated dynamically in HardwareUtil.fetchJavaScriptForHardware():
// velocityIdentifier
// The following are defined in vars.js:
// createNonEditableField
// getPropertyColor
// functionColor

Blockly.Blocks['velocity_getProperty'] = {
  init: function() {
    var PROPERTY_CHOICES = [
        ['DistanceUnit', 'DistanceUnit'],
        ['XVeloc', 'XVeloc'],
        ['YVeloc', 'YVeloc'],
        ['ZVeloc', 'ZVeloc'],
        ['AcquisitionTime', 'AcquisitionTime'],
    ];
    this.setOutput(true, null);
    this.appendDummyInput()
        .appendField(createNonEditableField('Velocity'))
        .appendField('.')
        .appendField(new Blockly.FieldDropdown(PROPERTY_CHOICES), 'PROP');
    this.appendValueInput('VELOCITY')
        .appendField('velocity')
        .setCheck('Velocity')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.setColour(getPropertyColor);
    // Assign 'this' to a variable for use in the tooltip closure below.
    var thisBlock = this;
    var TOOLTIPS = [
        ['DistanceUnit', 'The DistanceUnit of the given Velocity object.'],
        ['XVeloc', 'The XVeloc of the given Velocity object.'],
        ['YVeloc', 'The YVeloc of the given Velocity object.'],
        ['ZVeloc', 'The ZVeloc of the given Velocity object.'],
        ['AcquisitionTime', 'The AcquisitionTime of the given Velocity object.'],
    ];
    this.setTooltip(function() {
      var key = thisBlock.getFieldValue('PROP');
      for (var i = 0; i < TOOLTIPS.length; i++) {
        if (TOOLTIPS[i][0] == key) {
          return TOOLTIPS[i][1];
        }
      }
      return '';
    });
  }
};

Blockly.JavaScript['velocity_getProperty'] = function(block) {
  var property = block.getFieldValue('PROP');
  var velocity = Blockly.JavaScript.valueToCode(
      block, 'VELOCITY', Blockly.JavaScript.ORDER_NONE);
  var code = velocityIdentifier + '.get' + property + '(' + velocity + ')';
  return [code, Blockly.JavaScript.ORDER_FUNCTION_CALL];
};

// Functions

Blockly.Blocks['velocity_create'] = {
  init: function() {
    this.setOutput(true, 'Velocity');
    this.appendDummyInput()
        .appendField('new')
        .appendField(createNonEditableField('Velocity'));
    this.setColour(functionColor);
    this.setTooltip('Create a new Velocity object.');
  }
};

Blockly.JavaScript['velocity_create'] = function(block) {
  var code = velocityIdentifier + '.create()';
  return [code, Blockly.JavaScript.ORDER_FUNCTION_CALL];
};

Blockly.Blocks['velocity_create_withArgs'] = {
  init: function() {
    this.setOutput(true, 'Velocity');
    this.appendDummyInput()
        .appendField('new')
        .appendField(createNonEditableField('Velocity'));
    this.appendValueInput('DISTANCE_UNIT')
        .appendField('distanceUnit')
        .setCheck('DistanceUnit')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.appendValueInput('X_VELOC')
        .appendField('XVeloc')
        .setCheck('Number')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.appendValueInput('Y_VELOC')
        .appendField('YVeloc')
        .setCheck('Number')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.appendValueInput('Z_VELOC')
        .appendField('ZVeloc')
        .setCheck('Number')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.appendValueInput('ACQUISITION_TIME')
        .appendField('acquisitionTime')
        .setCheck('Number')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.setColour(functionColor);
    this.setTooltip('Create a new Velocity object.');
  }
};

Blockly.JavaScript['velocity_create_withArgs'] = function(block) {
  var distanceUnit = Blockly.JavaScript.valueToCode(
      block, 'DISTANCE_UNIT', Blockly.JavaScript.ORDER_NONE);
  var xVeloc = Blockly.JavaScript.valueToCode(
      block, 'X_VELOC', Blockly.JavaScript.ORDER_NONE);
  var yVeloc = Blockly.JavaScript.valueToCode(
      block, 'Y_VELOC', Blockly.JavaScript.ORDER_NONE);
  var zVeloc = Blockly.JavaScript.valueToCode(
      block, 'Z_VELOC', Blockly.JavaScript.ORDER_NONE);
  var acquisitionTime = Blockly.JavaScript.valueToCode(
      block, 'ACQUISITION_TIME', Blockly.JavaScript.ORDER_NONE);
  var code = velocityIdentifier + '.create_withArgs(' + distanceUnit + ', ' + xVeloc + ', ' +
      yVeloc + ', ' + zVeloc + ', ' + acquisitionTime + ')';
  return [code, Blockly.JavaScript.ORDER_FUNCTION_CALL];
};

Blockly.Blocks['velocity_toDistanceUnit'] = {
  init: function() {
    this.setOutput(true, 'Velocity');
    this.appendDummyInput()
        .appendField('call')
        .appendField(createNonEditableField('Velocity'))
        .appendField('.')
        .appendField(createNonEditableField('toDistanceUnit'));
    this.appendValueInput('VELOCITY')
        .appendField('velocity')
        .setCheck('Velocity')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.appendValueInput('DISTANCE_UNIT')
        .appendField('distanceUnit')
        .setCheck('DistanceUnit')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.setColour(functionColor);
    this.setTooltip('Returns a new Velocity object created from the given Velocity ' +
        'object and distance unit.');
  }
};

Blockly.JavaScript['velocity_toDistanceUnit'] = function(block) {
  var velocity = Blockly.JavaScript.valueToCode(
      block, 'VELOCITY', Blockly.JavaScript.ORDER_NONE);
  var distanceUnit = Blockly.JavaScript.valueToCode(
      block, 'DISTANCE_UNIT', Blockly.JavaScript.ORDER_NONE);
  var code = velocityIdentifier + '.toDistanceUnit(' + velocity + ', ' + distanceUnit + ')';
  return [code, Blockly.JavaScript.ORDER_FUNCTION_CALL];
};

Blockly.Blocks['velocity_toText'] = {
  init: function() {
    this.setOutput(true, 'String');
    this.appendDummyInput()
        .appendField('call')
        .appendField(createNonEditableField('Velocity'))
        .appendField('.')
        .appendField(createNonEditableField('toText'));
    this.appendValueInput('VELOCITY')
        .appendField('velocity')
        .setCheck('Velocity')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.setColour(functionColor);
    this.setTooltip('Returns a text representation of the given Velocity object.');
  }
};

Blockly.JavaScript['velocity_toText'] = function(block) {
  var velocity = Blockly.JavaScript.valueToCode(
      block, 'VELOCITY', Blockly.JavaScript.ORDER_NONE);
  var code = velocityIdentifier + '.toText(' + velocity + ')';
  return [code, Blockly.JavaScript.ORDER_FUNCTION_CALL];
};
