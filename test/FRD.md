# FRD - Functional Requirements

## 1. User Capabilities
- Upload batch files (CSV/Parquet/text).
- Stream application/system events.
- Discover datasets via catalog.
- Run queries and consume dashboards.

## 2. Functional Requirements
1. System shall accept file ingestion to raw zone.
2. System shall accept event/log streaming ingestion.
3. System shall validate, classify, and partition incoming data.
4. System shall transform raw data to curated analytics-ready datasets.
5. System shall register dataset metadata and schema in catalog.
6. System shall support SQL querying over curated datasets.
7. System shall provide dashboards for defined KPIs.
8. System shall generate alerts for ingestion/processing failures.
9. System shall enforce role-based access controls.
10. System shall retain audit logs of critical operations.

## 3. Error Handling Requirements
- Failed records routed to DLQ/error bucket with diagnostics.
- Retry policies for transient failures.
- Operator-visible failure reasons.

## 4. Reporting Requirements
- Freshness status by dataset.
- Pipeline run status and SLA adherence.
- Top failed pipelines and root-cause tags.
