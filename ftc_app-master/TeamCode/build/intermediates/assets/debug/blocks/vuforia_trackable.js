/**
 * @fileoverview FTC robot blocks related to VuforiaTrackable
 * @author lizlooney@google.com (Liz Looney)
 */

// The following are generated dynamically in HardwareUtil.fetchJavaScriptForHardware():
// vuforiaTrackableIdentifier
// The following are defined in vars.js:
// createNonEditableField
// getPropertyColor
// functionColor

Blockly.Blocks['vuforiaTrackable_getProperty'] = {
  init: function() {
    var PROPERTY_CHOICES = [
        ['Location', 'Location'],
        ['UserData', 'UserData'],
        ['Trackables', 'Trackables'],
        ['Name', 'Name'],
        ['Listener', 'Listener'],
    ];
    this.setOutput(true, null);
    this.appendDummyInput()
        .appendField(createNonEditableField('VuforiaTrackable'))
        .appendField('.')
        .appendField(new Blockly.FieldDropdown(PROPERTY_CHOICES), 'PROP');
    this.appendValueInput('VUFORIA_TRACKABLE')
        .appendField('vuforiaTrackable')
        .setCheck('VuforiaTrackable')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.setColour(getPropertyColor);
    // Assign 'this' to a variable for use in the tooltip closure below.
    var thisBlock = this;
    var TOOLTIPS = [
        ['Location', 'Returns the location of the given VuforiaTrackable in the FTC field ' +
            'coordinate system, as an OpenGLMatrix object.'],
        ['UserData', 'Retreives user data previously associated with the given ' +
            'VuforableTrackable.'],
        ['Trackables', 'Returns the VuforiaTrackables of which the given VuforiaTrackable is a member.'],
        ['Name', 'Returns the user-specified name for the given VuforiaTrackable.'],
        ['Listener', 'Returns the VuforiaTrackableDefaultListener associated with the given VuforiaTrackable.'],
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

Blockly.JavaScript['vuforiaTrackable_getProperty'] = function(block) {
  var property = block.getFieldValue('PROP');
  var vuforiaTrackable = Blockly.JavaScript.valueToCode(
      block, 'VUFORIA_TRACKABLE', Blockly.JavaScript.ORDER_NONE);
  var code = vuforiaTrackableIdentifier + '.get' + property + '(' + vuforiaTrackable + ')';
  return [code, Blockly.JavaScript.ORDER_FUNCTION_CALL];
};

// Functions

Blockly.Blocks['vuforiaTrackable_setLocation'] = {
  init: function() {
    this.appendDummyInput()
        .appendField('call')
        .appendField(createNonEditableField('VuforiaTrackable'))
        .appendField('.')
        .appendField(createNonEditableField('setLocation'));
    this.appendValueInput('VUFORIA_TRACKABLE')
        .appendField('vuforiaTrackable')
        .setCheck('VuforiaTrackable')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.appendValueInput('MATRIX')
        .appendField('matrix')
        .setCheck('OpenGLMatrix')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.setPreviousStatement(true);
    this.setNextStatement(true);
    this.setColour(functionColor);
    this.setTooltip('Sets the location of the given VuforiaTrackable in the FTC field ' +
        'coordinate system, to the given OpenGLMatrix.');
  }
};

Blockly.JavaScript['vuforiaTrackable_setLocation'] = function(block) {
  var vuforiaTrackable = Blockly.JavaScript.valueToCode(
      block, 'VUFORIA_TRACKABLE', Blockly.JavaScript.ORDER_NONE);
  var matrix = Blockly.JavaScript.valueToCode(
      block, 'MATRIX', Blockly.JavaScript.ORDER_NONE);
  return vuforiaTrackableIdentifier + '.setLocation(' + vuforiaTrackable + ', ' + matrix + ');\n';
};

Blockly.Blocks['vuforiaTrackable_setUserData'] = {
  init: function() {
    this.appendDummyInput()
        .appendField('call')
        .appendField(createNonEditableField('VuforiaTrackable'))
        .appendField('.')
        .appendField(createNonEditableField('setUserData'));
    this.appendValueInput('VUFORIA_TRACKABLE')
        .appendField('vuforiaTrackable')
        .setCheck('VuforiaTrackable')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.appendValueInput('USER_DATA')
        .appendField('userData')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.setPreviousStatement(true);
    this.setNextStatement(true);
    this.setColour(functionColor);
    this.setTooltip('Sets user data to be associated with the given VuforiaTrackable.');
  }
};

Blockly.JavaScript['vuforiaTrackable_setUserData'] = function(block) {
  var vuforiaTrackable = Blockly.JavaScript.valueToCode(
      block, 'VUFORIA_TRACKABLE', Blockly.JavaScript.ORDER_NONE);
  var userData = Blockly.JavaScript.valueToCode(
      block, 'USER_DATA', Blockly.JavaScript.ORDER_NONE);
  return vuforiaTrackableIdentifier + '.setUserData(' + vuforiaTrackable + ', ' + userData + ');\n';
};

Blockly.Blocks['vuforiaTrackable_setName'] = {
  init: function() {
    this.appendDummyInput()
        .appendField('call')
        .appendField(createNonEditableField('VuforiaTrackable'))
        .appendField('.')
        .appendField(createNonEditableField('setName'));
    this.appendValueInput('VUFORIA_TRACKABLE')
        .appendField('vuforiaTrackable')
        .setCheck('VuforiaTrackable')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.appendValueInput('NAME')
        .appendField('name')
        .setCheck('String')
        .setAlign(Blockly.ALIGN_RIGHT);
    this.setPreviousStatement(true);
    this.setNextStatement(true);
    this.setColour(functionColor);
    this.setTooltip('Sets a user-determined name associated with the given VuforiaTrackable. ' +
        'This is mostly useful for debugging.');
  }
};

Blockly.JavaScript['vuforiaTrackable_setName'] = function(block) {
  var vuforiaTrackable = Blockly.JavaScript.valueToCode(
      block, 'VUFORIA_TRACKABLE', Blockly.JavaScript.ORDER_NONE);
  var name = Blockly.JavaScript.valueToCode(
      block, 'NAME', Blockly.JavaScript.ORDER_NONE);
  return vuforiaTrackableIdentifier + '.setName(' + vuforiaTrackable + ', ' + name + ');\n';
};
