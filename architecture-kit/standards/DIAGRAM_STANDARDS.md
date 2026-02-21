# Diagram Standards (draw.io)

## Diagram Set (Minimum)
- Context
- Container
- Deployment
- Sequence (critical path)
- Data Flow

## Visual Conventions
- Left-to-right primary flow
- Group by trust boundary/network zone
- Label all arrows (protocol/action)
- Use consistent color coding:
  - Client/UI: blue
  - Services: yellow
  - Data stores: red/pink
  - External systems: purple
  - Security/ops: gray/orange

## Cloud/Icon Guidance
- Use official AWS/Azure/GCP icon packs for provider-specific diagrams
- Keep generic version if cloud-agnostic
- Avoid mixing icon styles in one diagram

## Professional Checklist
- Title + version + date
- Legend included
- Every component has responsibility label
- Security controls shown (auth, encryption, audit)
- Failure/retry path shown for critical integrations
