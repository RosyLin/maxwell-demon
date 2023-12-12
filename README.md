# Project Overview: Maxwell's Demon Game
## COSC 150 - Advanced Programming

### Introduction
The Maxwell's Demon project is an interactive Java application that simulates a thought experiment by the 19th-century physicist James Maxwell. The project involves creating a graphical user interface (GUI) using Swing, modeling a simple physical system, and employing event-driven programming to update the game state in response to user inputs.

### Project Goals
- Design and implement a user-friendly GUI.
- Model the movement and interaction of particles in a divided chamber.
- Use event-driven programming for real-time game updates.

### Project Description
Maxwell's Demon is an interactive game where players control a 'demon' to manipulate particles within a two-chambered system. The objective is to separate fast (hot) and slow (cold) particles into different chambers, challenging the second law of thermodynamics. The game features a dynamic GUI with responsive controls and real-time physics simulation.

### Key Features
- **Interactive GUI**: A split-screen playing area with a movable door controlled by mouse clicks.
- **Particle Simulation**: Color-coded particles (red for hot, blue for cold) that move and interact within the chambers.
- **Game Mechanics**: Buttons for adding particles and resetting the game, along with a display showing the temperature in each chamber.
- **Physical Modeling**: Simulation of particle speeds and behaviors, with temperature calculations based on particle velocities.

### Technical Specifications
- **Language**: Java, with Swing for the GUI.
- **Physics Engine**: Custom-built engine to simulate particle kinematics and thermodynamics.
- **Screen Resolution Handling**: Utilized `java.awt.Toolkit` for adapting particle speeds to different screen resolutions.

### Documentation and Design
- **GUIDesign.pdf**: A visual representation of the game interface.
- **ObjectDiagram.pdf**: UML object diagram detailing the program's structure and the relationships between its components.

### Development Process
The project involved several stages, from initial design sketches to coding and testing. Particular emphasis was placed on the seamless integration of the GUI with the underlying physical model, ensuring an engaging and educational experience.

### Learning Outcomes
- Enhanced understanding of GUI design principles and Swing components.
- Deepened knowledge of modeling physical systems and event-driven programming.
- Practical experience in translating theoretical concepts into an interactive application.

### Conclusion
The Maxwell's Demon project successfully demonstrates the application of advanced programming concepts to create an educational and engaging game. It highlights the interplay between physics, user interface design, and software development in creating an interactive experience.
