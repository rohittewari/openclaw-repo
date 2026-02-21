# Diagram Generation Prompt

Use this prompt to generate draft diagram content (Mermaid/PlantUML) before finalizing in draw.io.

## Prompt
Create professional architecture diagram specs for this system.

Include:
1. System Context Diagram
2. Container Diagram
3. Deployment Diagram
4. Sequence Diagram for critical flow
5. Data Flow Diagram

For each diagram provide:
- Purpose
- Components and boundaries
- Directed connections with labels
- Failure/retry/security notes
- Suggested icon mapping (AWS/Azure/GCP or generic)
- Draft Mermaid syntax

Output should be directly transferable to draw.io.
