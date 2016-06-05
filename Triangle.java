class Triangle{

	TriangleKind kind;
	
	public Triangle(double side1, double side2, double side3) throws TriangleException {
		if (side1 == 0 && side2 == 0 && side3 == 0) throw new TriangleException();
		if ((side1 + side2 <= side3) ||
		    (side2 + side3 <= side1) ||
	        (side1 + side3 <= side2)) throw new TriangleException();
		if ((side1 < 0 || side2 < 0 || side3 < 0)) throw new TriangleException();
		
		System.out.println(side1 + side2 < side3);
		if (side1 == side2 && side2 == side3) kind = TriangleKind.EQUILATERAL;
		else if (side1 == side2 ||
				 side1 == side3 ||
				 side2 == side3) kind = TriangleKind.ISOSCELES;
		else kind = TriangleKind.SCALENE;
	}

	public TriangleKind getKind(){
		return kind;
	}
}