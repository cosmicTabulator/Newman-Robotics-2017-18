/**
 * @fileoverview FTC robot blocks related to navigation.
 * @author lizlooney@google.com (Liz Looney)
 */

// The following are defined in vars.js:
// getPropertyColor

// Enums

Blockly.Blocks['navigation_enum_angleUnit'] = {
  init: function() {
    var ANGLE_UNIT_CHOICES = [
        ['DEGREES', 'DEGREES'],
        ['RADIANS', 'RADIANS'],
    ];
    this.setOutput(true, 'AngleUnit');
    this.appendDummyInput()
        .appendField('AngleUnit')
        .appendField('.')
        .appendField(new Blockly.FieldDropdown(ANGLE_UNIT_CHOICES), 'ANGLE_UNIT');
    this.setColour(getPropertyColor);
    // Assign 'this' to a variable for use in the tooltip closure below.
    var thisBlock = this;
    var TOOLTIPS = [
        ['DEGREES', 'The AngleUnit value DEGREES.'],
        ['RADIANS', 'The AngleUnit value RADIANS.'],
    ];
    this.setTooltip(function() {
      var key = thisBlock.getFieldValue('ANGLE_UNIT');
      for (var i = 0; i < TOOLTIPS.length; i++) {
        if (TOOLTIPS[i][0] == key) {
          return TOOLTIPS[i][1];
        }
      }
      return '';
    });
  }
};

Blockly.JavaScript['navigation_enum_angleUnit'] = function(block) {
  var code = '"' + block.getFieldValue('ANGLE_UNIT') + '"';
  return [code, Blockly.JavaScript.ORDER_ATOMIC];
};

Blockly.Blocks['navigation_enum_axesOrder'] = {
  init: function() {
    var AXES_ORDER_CHOICES = [
        ['XYX', 'XYX'],
        ['XYZ', 'XYZ'],
        ['XZX', 'XZX'],
        ['XZY', 'XZY'],
        ['YXY', 'YXY'],
        ['YXZ', 'YXZ'],
        ['YZX', 'YZX'],
        ['YZY', 'YZY'],
        ['ZXY', 'ZXY'],
        ['ZXZ', 'ZXZ'],
        ['ZYX', 'ZYX'],
        ['ZYZ', 'ZYZ'],
    ];
    this.setOutput(true, 'AxesOrder');
    this.appendDummyInput()
        .appendField('AxesOrder')
        .appendField('.')
        .appendField(new Blockly.FieldDropdown(AXES_ORDER_CHOICES), 'AXES_ORDER');
    this.setColour(getPropertyColor);
    // Assign 'this' to a variable for use in the tooltip closure below.
    var thisBlock = this;
    var TOOLTIPS = [
        ['XYX', 'The AxesOrder value XYX.'],
        ['XYZ', 'The AxesOrder value XYZ.'],
        ['XZX', 'The AxesOrder value XZX.'],
        ['XZY', 'The AxesOrder value XZY.'],
        ['YXY', 'The AxesOrder value YXY.'],
        ['YXZ', 'The AxesOrder value YXZ.'],
        ['YZX', 'The AxesOrder value YZX.'],
        ['YZY', 'The AxesOrder value YZY.'],
        ['ZXY', 'The AxesOrder value ZXY.'],
        ['ZXZ', 'The AxesOrder value ZXZ.'],
        ['ZYX', 'The AxesOrder value ZYX.'],
        ['ZYZ', 'The AxesOrder value ZYZ.'],
    ];
    this.setTooltip(function() {
      var key = thisBlock.getFieldValue('AXES_ORDER');
      for (var i = 0; i < TOOLTIPS.length; i++) {
        if (TOOLTIPS[i][0] == key) {
          return TOOLTIPS[i][1];
        }
      }
      return '';
    });
  }
};

Blockly.JavaScript['navigation_enum_axesOrder'] = function(block) {
  var code = '"' + block.getFieldValue('AXES_ORDER') + '"';
  return [code, Blockly.JavaScript.ORDER_ATOMIC];
};

Blockly.Blocks['navigation_enum_axesReference'] = {
  init: function() {
    var AXES_REFERENCE_CHOICES = [
        ['EXTRINSIC', 'EXTRINSIC'],
        ['INTRINSIC', 'INTRINSIC'],
    ];
    this.setOutput(true, 'AxesReference');
    this.appendDummyInput()
        .appendField('AxesReference')
        .appendField('.')
        .appendField(new Blockly.FieldDropdown(AXES_REFERENCE_CHOICES), 'AXES_REFERENCE');
    this.setColour(getPropertyColor);
    // Assign 'this' to a variable for use in the tooltip closure below.
    var thisBlock = this;
    var TOOLTIPS = [
        ['EXTRINSIC', 'The AxesReference value EXTRINSIC.'],
        ['INTRINSIC', 'The AxesReference value INTRINSIC.'],
    ];
    this.setTooltip(function() {
      var key = thisBlock.getFieldValue('AXES_REFERENCE');
      for (var i = 0; i < TOOLTIPS.length; i++) {
        if (TOOLTIPS[i][0] == key) {
          return TOOLTIPS[i][1];
        }
      }
      return '';
    });
  }
};

Blockly.JavaScript['navigation_enum_axesReference'] = function(block) {
  var code = '"' + block.getFieldValue('AXES_REFERENCE') + '"';
  return [code, Blockly.JavaScript.ORDER_ATOMIC];
};

Blockly.Blocks['navigation_enum_cameraDirection'] = {
  init: function() {
    var CAMERA_DIRECTION_CHOICES = [
        ['BACK', 'BACK'],
        ['FRONT', 'FRONT'],
    ];
    this.setOutput(true, 'CameraDirection');
    this.appendDummyInput()
        .appendField('CameraDirection')
        .appendField('.')
        .appendField(new Blockly.FieldDropdown(CAMERA_DIRECTION_CHOICES), 'CAMERA_DIRECTION');
    this.setColour(getPropertyColor);
    // Assign 'this' to a variable for use in the tooltip closure below.
    var thisBlock = this;
    var TOOLTIPS = [
        ['BACK', 'The CameraDirection value BACK.'],
        ['FRONT', 'The CameraDirection value FRONT.'],
    ];
    this.setTooltip(function() {
      var key = thisBlock.getFieldValue('CAMERA_DIRECTION');
      for (var i = 0; i < TOOLTIPS.length; i++) {
        if (TOOLTIPS[i][0] == key) {
          return TOOLTIPS[i][1];
        }
      }
      return '';
    });
  }
};

Blockly.JavaScript['navigation_enum_cameraDirection'] = function(block) {
  var code = '"' + block.getFieldValue('CAMERA_DIRECTION') + '"';
  return [code, Blockly.JavaScript.ORDER_ATOMIC];
};

Blockly.Blocks['navigation_enum_cameraMonitorFeedback'] = {
  init: function() {
    var CAMERA_MONITOR_FEEDBACK_CHOICES = [
        ['DEFAULT', 'DEFAULT'],
        ['NONE', 'NONE'],
        ['AXES', 'AXES'],
        ['TEAPOT', 'TEAPOT'],
        ['BUILDINGS', 'BUILDINGS'],
    ];
    this.setOutput(true, 'CameraMonitorFeedback');
    this.appendDummyInput()
        .appendField('CameraMonitorFeedback')
        .appendField('.')
        .appendField(new Blockly.FieldDropdown(CAMERA_MONITOR_FEEDBACK_CHOICES), 'CAMERA_MONITOR_FEEDBACK');
    this.setColour(getPropertyColor);
    // Assign 'this' to a variable for use in the tooltip closure below.
    var thisBlock = this;
    var TOOLTIPS = [
        ['DEFAULT', 'The CameraMonitorFeedback value DEFAULT.'],
        ['NONE', 'The CameraMonitorFeedback value NONE.'],
        ['AXES', 'The CameraMonitorFeedback value AXES.'],
        ['TEAPOT', 'The CameraMonitorFeedback value TEAPOT.'],
        ['BUILDINGS', 'The CameraMonitorFeedback value BUILDINGS.'],
    ];
    this.setTooltip(function() {
      var key = thisBlock.getFieldValue('CAMERA_MONITOR_FEEDBACK');
      for (var i = 0; i < TOOLTIPS.length; i++) {
        if (TOOLTIPS[i][0] == key) {
          return TOOLTIPS[i][1];
        }
      }
      return '';
    });
  }
};

Blockly.JavaScript['navigation_enum_cameraMonitorFeedback'] = function(block) {
  var code = '"' + block.getFieldValue('CAMERA_MONITOR_FEEDBACK') + '"';
  return [code, Blockly.JavaScript.ORDER_ATOMIC];
};

Blockly.Blocks['navigation_enum_distanceUnit'] = {
  init: function() {
    var DISTANCE_UNIT_CHOICES = [
        ['CM', 'CM'],
        ['INCH', 'INCH'],
        ['METER', 'METER'],
        ['MM', 'MM'],
    ];
    this.setOutput(true, 'DistanceUnit');
    this.appendDummyInput()
        .appendField('DistanceUnit')
        .appendField('.')
        .appendField(new Blockly.FieldDropdown(DISTANCE_UNIT_CHOICES), 'DISTANCE_UNIT');
    this.setColour(getPropertyColor);
    // Assign 'this' to a variable for use in the tooltip closure below.
    var thisBlock = this;
    var TOOLTIPS = [
        ['CM', 'The DistanceUnit value CM.'],
        ['INCH', 'The DistanceUnit value INCH.'],
        ['METER', 'The DistanceUnit value METER.'],
        ['MM', 'The DistanceUnit value MM.'],
    ];
    this.setTooltip(function() {
      var key = thisBlock.getFieldValue('DISTANCE_UNIT');
      for (var i = 0; i < TOOLTIPS.length; i++) {
        if (TOOLTIPS[i][0] == key) {
          return TOOLTIPS[i][1];
        }
      }
      return '';
    });
  }
};

Blockly.JavaScript['navigation_enum_distanceUnit'] = function(block) {
  var code = '"' + block.getFieldValue('DISTANCE_UNIT') + '"';
  return [code, Blockly.JavaScript.ORDER_ATOMIC];
};

Blockly.Blocks['navigation_enum_tempUnit'] = {
  init: function() {
    var TEMP_UNIT_CHOICES = [
        ['CELSIUS', 'CELSIUS'],
        ['FARENHEIT', 'FARENHEIT'],
        ['KELVIN', 'KELVIN'],
    ];
    this.setOutput(true, 'TempUnit');
    this.appendDummyInput()
        .appendField('TempUnit')
        .appendField('.')
        .appendField(new Blockly.FieldDropdown(TEMP_UNIT_CHOICES), 'TEMP_UNIT');
    this.setColour(getPropertyColor);
    // Assign 'this' to a variable for use in the tooltip closure below.
    var thisBlock = this;
    var TOOLTIPS = [
        ['CELSIUS', 'The TempUnit value CELSIUS.'],
        ['FARENHEIT', 'The TempUnit value FARENHEIT.'],
        ['KELVIN', 'The TempUnit value KELVIN.'],
    ];
    this.setTooltip(function() {
      var key = thisBlock.getFieldValue('TEMP_UNIT');
      for (var i = 0; i < TOOLTIPS.length; i++) {
        if (TOOLTIPS[i][0] == key) {
          return TOOLTIPS[i][1];
        }
      }
      return '';
    });
  }
};

Blockly.JavaScript['navigation_enum_tempUnit'] = function(block) {
  var code = '"' + block.getFieldValue('TEMP_UNIT') + '"';
  return [code, Blockly.JavaScript.ORDER_ATOMIC];
};

