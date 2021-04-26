package mainPackage.geometry;

public class MyFigure extends Figure {
    private Face[] faces;
    private Vertex[] vertices;
    private Vertex center;
    public  double a = 50;
    public  double d = 200;
    public  double c = 200;
    public  double h = 200;




    public MyFigure(double a, double d, double c, double h) {
        buildVertices();
        buildFaces();
        buildEdges();
    }



    @Override
    public void buildEdges() {

        faces[0].setEdges(new Edge[]{

                new Edge(vertices[0], vertices[1]),
                new Edge(vertices[1], vertices[2]),
                new Edge(vertices[2], vertices[3]),
                new Edge(vertices[3], vertices[4]),
                new Edge(vertices[4], vertices[5]),
                new Edge(vertices[5], vertices[6]),
                new Edge(vertices[6], vertices[7]),
                new Edge(vertices[7], vertices[0]),
        });
        faces[1].setEdges(new Edge[]{
                new Edge(vertices[8], vertices[9]),
                new Edge(vertices[9], vertices[10]),
                new Edge(vertices[10], vertices[11]),
                new Edge(vertices[11], vertices[12]),
                new Edge(vertices[12], vertices[13]),
                new Edge(vertices[13], vertices[14]),
                new Edge(vertices[14], vertices[15]),
                new Edge(vertices[15], vertices[8]),
        });
        faces[2].setEdges(new Edge[]{
                new Edge(vertices[0], vertices[1]),
                new Edge(vertices[1], vertices[9]),
                new Edge(vertices[9], vertices[8]),
                new Edge(vertices[8], vertices[0])
        });
        faces[3].setEdges(new Edge[]{
                new Edge(vertices[2], vertices[3]),
                new Edge(vertices[3], vertices[11]),
                new Edge(vertices[11], vertices[10]),
                new Edge(vertices[10], vertices[2])
        });
        faces[4].setEdges(new Edge[]{
                new Edge(vertices[1], vertices[2]),
                new Edge(vertices[2], vertices[10]),
                new Edge(vertices[10], vertices[9]),
                new Edge(vertices[9], vertices[1])
        });
        faces[5].setEdges(new Edge[]{
                new Edge(vertices[0], vertices[7]),
                new Edge(vertices[7], vertices[15]),
                new Edge(vertices[15], vertices[8]),
                new Edge(vertices[8], vertices[0])
        });
        faces[6].setEdges(new Edge[]{
                new Edge(vertices[3], vertices[4]),
                new Edge(vertices[4], vertices[12]),
                new Edge(vertices[12], vertices[11]),
                new Edge(vertices[11], vertices[3])
        });
        faces[7].setEdges(new Edge[]{
                new Edge(vertices[6], vertices[7]),
                new Edge(vertices[7], vertices[15]),
                new Edge(vertices[15], vertices[14]),
                new Edge(vertices[14], vertices[6])
        });
        faces[8].setEdges(new Edge[]{
                new Edge(vertices[6], vertices[5]),
                new Edge(vertices[5], vertices[13]),
                new Edge(vertices[13], vertices[14]),
                new Edge(vertices[14], vertices[6])
        });
        faces[9].setEdges(new Edge[]{
                new Edge(vertices[5], vertices[4]),
                new Edge(vertices[4], vertices[12]),
                new Edge(vertices[12], vertices[13]),
                new Edge(vertices[13], vertices[5])
        });


    }

    @Override
    public void buildFaces() {
        faces = new Face[]{
                new Face(vertices[0], vertices[1], vertices[2], vertices[3], vertices[4], vertices[5], vertices[6]
                        , vertices[7]),
                new Face(vertices[10], vertices[9], vertices[8], vertices[15], vertices[14], vertices[13], vertices[12],
                        vertices[11]),
                new Face(vertices[9], vertices[1], vertices[0], vertices[8]),//
                new Face(vertices[3], vertices[2], vertices[10], vertices[11]),//
                new Face(vertices[1], vertices[9], vertices[10], vertices[2]),//
                new Face(vertices[0], vertices[7], vertices[15], vertices[8]),//
                new Face(vertices[4], vertices[3], vertices[11], vertices[12]),//
                new Face(vertices[6], vertices[14], vertices[15], vertices[7]),//
                new Face(vertices[6], vertices[5], vertices[13], vertices[14]),//
                new Face(vertices[5], vertices[4], vertices[12], vertices[13])//

        };
        super.setFaces(faces);
    }
    public void changeFigureSize(double a, double d, double c, double h) {
        this.a = a;
        this.d = d;
        this.c = c;
        this.h = h;
        buildVertices();
        buildFaces();
        buildEdges();
    }


    @Override
    public void buildVertices() {
        vertices = new Vertex[]{
                new Vertex(0, 0, 0),//1
                new Vertex(0, h, 0),//2
                new Vertex( d, h, 0),//3
                new Vertex(d, 0, 0),//4
                new Vertex(d - a, 0, 0),//5
                new Vertex(d - a, h - a, 0),//6
                new Vertex( a, h - a, 0),//7
                new Vertex( a, 0, 0),//8
                new Vertex(0, 0, c),//9
                new Vertex(0, h, c),//10
                new Vertex(d, h, c),//11
                new Vertex(d, 0, c),//12
                new Vertex(d - a, 0, c),//13
                new Vertex(d - a, h - a, c),//14
                new Vertex(a, h - a, c),//15
                new Vertex(a, 0, c)//16


        };
        center = new Vertex(0, 0, 0);
        super.setVertices(vertices);
        super.setCenter(center);
    }
}
