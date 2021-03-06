package com.runbox.debug.script.expression.token.operand;

import com.sun.jdi.*;

import com.runbox.debug.manager.MachineManager;
import com.runbox.debug.script.expression.token.Token;

public class Operand extends Token {

    public Operand(String name) {
        super(name);
    }    
   	
	public Type type(Type type) throws Exception {
		throw new Exception("invalid operate");
	}
	
	public Type type() throws Exception {
		throw new Exception("invalid operate");
	}
	
	public Value value(Value value) throws Exception {
		throw new Exception("invalid operate");
	}
	
	public Value value() throws Exception {
		throw new Exception("invalid operate");
	}  

	public boolean isByte() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof ByteValue) {
				return true;
			}
		}
		return false;
	}

	public boolean isChar() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof CharValue) {
				return true;
			}			
		}
		return false;
	}

	public boolean isShort() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof ShortValue) {
				return true;
			}			
		}
		return false;
	}

	public boolean isInteger() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof IntegerValue) {
				return true;
			}			
		}
		return false;
	}

	public boolean isLong() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof LongValue) {
				return true;
			}			
		}
		return false;
	}

	public boolean isFloat() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof FloatValue) {
				return true;
			}			
		}
		return false;
	}

	public boolean isDouble() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof DoubleValue) {
				return true;
			}			
		}
		return false;
	}

	public boolean isBoolean() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof BooleanValue) {
				return true;
			}			
		}
		return false;
	}

	public boolean isString() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof StringReference) {
				return true;
			}			
		}
		return false;
	}
	
	public byte byteValue() throws Exception {		
		Value value = value();
		if (null != value) {
			if (value instanceof ByteValue) {
				return ((ByteValue)value).value();
			}
			throw new Exception("error value type");
		}
		throw new Exception("invalid null value");
	}

	public char charValue() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof CharValue) {
				return ((CharValue)value).value();
			}
			throw new Exception("error value type");
		}
		throw new Exception("invalid null value");
	}
	
	public short shortValue() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof ByteValue) {
				return ((ByteValue)value).value();
			} else if (value instanceof ShortValue) {
				return ((ShortValue)value).value();
			}
			throw new Exception("error value type");
		}
		throw new Exception("invalid null value");
	}
	
	public int intValue() throws Exception {
		Value value = value();
		if (null != value) {			
			if (value instanceof ByteValue) {
				return ((ByteValue)value).value();
			} else if (value instanceof ShortValue) {
				return ((ShortValue)value).value();
			} else if (value instanceof IntegerValue) {
				return ((IntegerValue)value).value();
			}
			throw new Exception("error value type");
		}
		throw new Exception("invalid null value");
	}
	
	public long longValue() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof ByteValue) {
				return ((ByteValue)value).value();
			} else if (value instanceof ShortValue) {
				return ((ShortValue)value).value();
			} else if (value instanceof IntegerValue) {
				return ((IntegerValue)value).value();
			} else if (value instanceof LongValue) {
				return ((LongValue)value).value();
			}
			throw new Exception("error value type");
		}
		throw new Exception("invalid null value");
	}
	
	public float floatValue() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof FloatValue) {
				return ((FloatValue)value).value();
			}				
			throw new Exception("error value type");
		}
		throw new Exception("invalid null value");
	}
	
	public double doubleValue() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof FloatValue) {
				return ((FloatValue)value).value();
			} else if (value instanceof DoubleValue) {
				return ((DoubleValue)value).value();
			}
			throw new Exception("error value type");
		}
		throw new Exception("invalid null value");
	}
	
	public boolean boolValue() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof BooleanValue) {
				return ((BooleanValue)value).value();
			} 
			throw new Exception("error value type");
		}
		throw new Exception("invalid null value");
	}
	
	public String strValue() throws Exception {
		Value value = value();
		if (null != value) {
			if (value instanceof StringReference) {
				return ((StringReference)value).value();
			} 
			throw new Exception("error value type");
		}
		throw new Exception("invalid null value");
	}		

    public static boolean subClass(Operand operand) {
        boolean condition = (operand instanceof ConstOperand);
        condition = condition || (operand instanceof FieldOperand);
        condition = condition || (operand instanceof LocalOperand);
        condition = condition || (operand instanceof AutoOperand);
        condition = condition || (operand instanceof ArrayOperand);
		condition = condition || (operand instanceof RoutineOperand);
        if (condition) {
            return true;
        }
        return false;
    }    
}
