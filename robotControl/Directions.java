package edu.ucalgary.ensf409;
public enum Directions {
    E{@Override
    public String toString() {
        // TODO Auto-generated method stub
        return "East";
    }     
    },
    N{@Override
    public String toString() {
        // TODO Auto-generated method stub
        return "North";
    }
    },
    NE{@Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Northeast";
    }
    },
    NW{@Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Northwest";
    }
    },
    S{@Override
    public String toString() {
        // TODO Auto-generated method stub
        return "South";
    }
    },
    SE{@Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Southeast";
    }
    },
    SW{@Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Southwest";
    }
    },
    W{@Override
    public String toString() {
        // TODO Auto-generated method stub
        return "West";
    }
    };
    public abstract String toString();
}
